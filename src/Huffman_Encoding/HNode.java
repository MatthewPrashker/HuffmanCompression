package Huffman_Encoding;
public abstract class HNode implements Comparable<HNode> {
    private double freq;
    private char symbol;
    HNode left_child = null;
    HNode right_child = null;
    
    /**
     * Merges a given Hnode with another Hnode by adding together frequencies
     * @param other The HNode we want to merge with the calling node
     * @return The resulting merged internal node
     */
    public HInternalNode merge(HNode other) {
        HInternalNode merged_node = new HInternalNode(this.freq + other.freq);
        merged_node.left_child = this;
        merged_node.right_child = other;
        return merged_node;
    }
    /**
     * HNodes are just compared by their frequencies
     * @param other A Hnode which we are comparing this node to. 
     * @return -1 if this < other, 0 if this == other, 1 if this > other
     */
    @Override
    public int compareTo(HNode other) {
        return Double.compare(this.freq, other.getFreq());
    }

    @Override
    /**
     * To string method for a node which returns symbol 
     * followed by frequency
     */
    public String toString() {
    	if(this instanceof HInternalNode) {
    		return "(" + this.freq + ")";
    	}
        return "(" + this.symbol + ": " + this.freq + ")";
    }

    public void setFreq(double _freq){this.freq = _freq;}
    public double getFreq() {return this.freq;}
    public void setSymbol(char _symbol){this.symbol = _symbol;}
    public char getSymbol() {return this.symbol;}
    public HNode getLeftChild() {return this.left_child;}
    public HNode getRightChild() {return this.right_child;}

}
