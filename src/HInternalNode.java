/**
 * Simple Class representing an interior node in the Huffman Tree. 
 * An Internal Node must always have either left or right children non-null
 * The symbol associated with an internal node is always the null character
 */
public class HInternalNode extends HNode {
    /**
     * @param _freq The frequency stored in the node
     */
    public HInternalNode(double _freq){
        this.setFreq(_freq);
        this.setSymbol('\0'); //Internal Nodes have NULL symbol
    }
}
