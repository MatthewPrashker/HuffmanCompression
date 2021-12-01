import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class HTree {
    
    private final FreqTable frequencies;
    private Map<Character, String> encoding; //The Map which is responsible for encoding string
                                             //consisting of characters in our alphabet
    private HNode root; //Root of the HTree which we build using the FreqTable frequencies
    
    public HTree(FreqTable _frequencies) {
        this.frequencies = _frequencies;
        this.encoding = new HashMap<Character, String>();
        buildTree();
        buildEncoding(this.root, "");
    }

    private void buildTree() {
        PriorityQueue<HNode> pq = new PriorityQueue<HNode>();
        for(Map.Entry<Character, Double> entry : this.frequencies.getFreqTable().entrySet()) {
            pq.add(new HLeafNode(entry.getKey(), entry.getValue()));
        }
        while(pq.size() >= 2) {
            HNode left = pq.poll();
            HNode right = pq.poll();
            pq.add(left.merge(right));
        }

        this.root = pq.poll();
    }

    public void buildEncoding(HNode node, String s) {
        if(node == null) {return;}
        if(node instanceof HLeafNode) {
            this.encoding.put(node.getSymbol(), s);
        }
        buildEncoding(node.getLeftChild(), s + '0');
        buildEncoding(node.getRightChild(), s + '1');
    }

    /**
     * Main function of the 
     * @param s The String we want to encode
     * @return A binary string representing the encoding of the String s
     * @throws IllegalArgumentException if the String s contains a character which
     * is not present in the frequency table
     */
    public String encode(String s) throws IllegalArgumentException {
        if(s.length() == 1) {
            return encoding.get(s.charAt(0));
        }
        return encoding.get(s.charAt(0)) + this.encode(s.substring(1));
    }


    /**
     * @param b A binary string which we must decode
     * @return A string whose Huffman compression is equal to the binary string b
     */
    public String decode(String b) {
        return "";
    }


}
