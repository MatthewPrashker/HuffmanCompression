package Huffman_Encoding;

/**
 * Represents a Leaf Node in the Huffman Tree.
 * Stores a positive frequency and a non-null character
 */
public class HLeafNode extends HNode {
    /**
     * @param _symbol The character stored in the leaf node
     * @param _freq The frequency of the associated character
     */
    public HLeafNode(char _symbol, double _freq) {
        this.setSymbol(_symbol);
        this.setFreq(_freq);
    }
}
