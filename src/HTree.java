import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class HTree {
    
    private FreqTable frequencies;
    private Map<Character, String> encoding;
    
    public HTree(FreqTable _frequencies) {
        this.frequencies = _frequencies;
        build();
    }

    private void build() {
        PriorityQueue<HNode> pq = new PriorityQueue<HNode>();

    }


    /**
     * Main function of the 
     * @param s The String we want to encode
     * @return A binary string representing the encoding of the String s
     * @throws IllegalArgumentException if the String s contains a character which
     * is not present in the frequency table
     */
    public String encode(String s) throws IllegalArgumentException {
        return "";
    }


    /**
     * @param b A binary string which we must decode
     * @return A string whose Huffman compression is equal to the binary string b
     */
    public String decode(String b) {

    }


}
