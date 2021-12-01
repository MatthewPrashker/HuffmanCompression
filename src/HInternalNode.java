public class HInternalNode extends HNode {
    public HInternalNode(double _freq){
        this.setFreq(_freq);
        this.setSymbol('\0'); //Internal Nodes have NULL symbol
    }
}
