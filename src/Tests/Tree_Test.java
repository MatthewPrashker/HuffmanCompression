package Tests;
import Huffman_Encoding.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Huffman_Encoding.FreqTable;
import Huffman_Encoding.HTree;

class Tree_Test {

	@Test
	void test1() {
		FreqTable frequencies = new FreqTable();
        frequencies.addCharacter('a', 10);
        frequencies.addCharacter('b', 5);
        frequencies.addCharacter('c', 1);
        HTree HuffmanTree = new HTree(frequencies);
        assertEquals("c", HuffmanTree.decode(HuffmanTree.encode("c")));
	}

}
