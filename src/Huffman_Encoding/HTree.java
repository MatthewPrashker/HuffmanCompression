package Huffman_Encoding;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class HTree {
    
    private final FreqTable frequencies;
    private Map<Character, String> encoding; //The Map which is responsible for encoding string
                                             //consisting of characters in our alphabet
    private Map<String, Character> decoding; //The Map which takes a binary string appearing as the encoding
                                             //of some character and returns the character
    private HNode root; //Root of the HTree which we build using the FreqTable frequencies
    
    /**
     * Constructs a Huffman Tree from the given frequency Table
     * @param _frequencies The Frequency table storing the relative frequencies
     * of symbols in our alphabet
     */
    public HTree(FreqTable _frequencies) {
        this.frequencies = _frequencies;
        this.encoding = new HashMap<Character, String>();
        this.decoding = new HashMap<String, Character>();
        buildTree();
        buildEncoding(this.root, "");
    }
    /**
     * Builds the Huffman Tree from the given frequency table
     * Repeatedly chooses the two nodes with smallest frequency and merges them
     */
    private void buildTree() {
        PriorityQueue<HNode> pq = new PriorityQueue<HNode>();
        for(Map.Entry<Character, Double> entry : this.frequencies.getFreqTable().entrySet()) {
            pq.add(new HLeafNode(entry.getKey(), entry.getValue()));
        }
        while(pq.size() > 1) {
            HNode left = pq.poll();
            HNode right = pq.poll();
            pq.add(left.merge(right));
        }

        this.root = pq.poll();
    }
    /**
     * Recursive method to build the Encoding Map of the Huffman Tree
     * @param node The node which is the root of the subtree we are currently processing
     * @param s The String we have built so far from the root of the tree to the current node
     */
    public void buildEncoding(HNode node, String s) {
        if(node == null) {return;}
        if(node instanceof HLeafNode) {
            this.encoding.put(node.getSymbol(), s);
            this.decoding.put(s, node.getSymbol());
        }
        buildEncoding(node.getLeftChild(), s + '0');
        buildEncoding(node.getRightChild(), s + '1');
    }

    /**
     * Main functionality of the HTree class which encodes a given string
     * @param s The String we want to encode
     * @return A binary string representing the encoding of the String s
     * @throws IllegalArgumentException if the String s is empty or
     *  contains a character which is not present in the frequency table
     */
    public String encode(String s) throws IllegalArgumentException {
        if(s.length() == 0) {
            throw new IllegalArgumentException("The string to encode must be non-empty");
        }
        if(!encoding.containsKey(s.charAt(0))) {
            throw new IllegalArgumentException("The string contains a character not in the alphabet");
        }
        if(s.length() == 1) {
            return encoding.get(s.charAt(0));
        }
        return encoding.get(s.charAt(0)) + this.encode(s.substring(1));
    }


    /**
     * @param b A binary string which we must decode
     * @return A string whose Huffman compression is equal to the binary string b
     * @throws IllegalArgumentException if the string cannot be decoded using
     * the given decoding map associated with the tree
     */
    public String decode(String b) {
        if(b.length() == 0) {return "";}
        String curr_string = "";
        int index = 0;
        while(!decoding.containsKey(curr_string)) {
            if(index == b.length()) { //If Index reaches past end of string, then we cannot decode it
                throw new IllegalArgumentException("Cannot decode the provided binary string");
            }
            curr_string += b.charAt(index);
            index++;
        }
        return decoding.get(curr_string) + decode(b.substring(index));
    }
}
