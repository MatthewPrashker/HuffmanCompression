
public class Driver {
    public static void main(String[] args) {
        FreqTable frequencies = new FreqTable();
        frequencies.addCharacter('a', 10);
        frequencies.addCharacter('b', 5);
        frequencies.addCharacter('c', 1);
        HTree HuffmanTree = new HTree(frequencies);
        System.out.println(HuffmanTree.encode("c"));
        System.out.println(HuffmanTree.encode("a"));
        System.out.println(HuffmanTree.decode("00"));
        frequencies.print();
    }
}
