public abstract class HNode implements Comparable<HNode> {
    private int freq;
    private char symbol;
    HNode left_child;
    HNode right_child;
    
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
        return Integer.compare(this.freq, other.getFreq());
    }

    public void setFreq(int _freq){this.freq = _freq;}
    public int getFreq() {return this.freq;}
    public void setSymbol(char _symbol){this.symbol = _symbol;}
    public char getSymbol() {return this.symbol;}
    public HNode getLeftChild() {return this.left_child;}
    public HNode getRightChild() {return this.right_child;}

}
