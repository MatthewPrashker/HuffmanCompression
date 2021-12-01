public class HInternalNode extends HNode {
    public HInternalNode(int _freq){
        this.setFreq(_freq);
        this.setSymbol('\0'); //Internal Nodes have NULL symbol
    }
}
