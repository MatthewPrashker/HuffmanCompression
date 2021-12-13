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
        //Characters with high frequency should be encoded to smaller strings
        //than characters with higher frequency. 
        assert(HuffmanTree.encode("a").length() < HuffmanTree.encode("c").length());
        //Most frequenct character should always have length 1
        assertEquals(HuffmanTree.encode("a").length(), 1);
	}
	
	@Test
	void test2() {
		FreqTable frequencies = new FreqTable();
        frequencies.addCharacter('a', 10);
        frequencies.addCharacter('b', 5);
        frequencies.addCharacter('c', 1);
        HTree HuffmanTree = new HTree(frequencies);
        //Encoding and then decoding a string should be the identity
        assertEquals("acb", HuffmanTree.decode(HuffmanTree.encode("acb")));
        
	}
	


}
