package Huffman_Encoding;
import java.io.File;  
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
    	HLeafNode h = new HLeafNode('d', 5);
    	String encoding_file = "";
    	String text_file = "";
    	String to_encode = "";
    	String to_write = "";
    	FreqTable frequencies = new FreqTable();
    	try {
    		encoding_file = args[0];
    	    text_file = args[1];
    	    to_write = args[2];
    	} catch(ArrayIndexOutOfBoundsException e) {
    		System.out.println("Enter Frequency File followed by File to encode followed by File to write to");
    		e.printStackTrace();
    	}
    	
    	try {	
    		File encoding = new File(encoding_file);
    		Scanner reader = new Scanner(encoding);
    		
    		//Construct the frequency table from the frequency file
    		
    		while(reader.hasNext()) {
    			char letter = reader.next().charAt(0);
        		double frequency = reader.nextDouble();
        		frequencies.addCharacter(letter, frequency);
    		}
    		
    	} catch(FileNotFoundException e) {
    		System.out.println("Frequency file not found");
    		e.printStackTrace();
    	}
        
    	try {
    		File text = new File(text_file);
    		Scanner reader = new Scanner(text);
    		to_encode = reader.next();
    	} catch(FileNotFoundException e) {
    		System.out.println("Text file to decode not found");
    		e.printStackTrace();
    	}
    	
    	try {
    		File decode = new File(to_write);
    		FileWriter writer = new FileWriter(decode);
    		
    		HTree HuffmanTree = new HTree(frequencies);
    		writer.write(HuffmanTree.encode(to_encode));
    		writer.flush();
    	} catch(FileNotFoundException e) {
    		System.out.println("Text file to write encoded binary not found");
    		e.printStackTrace();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    }
}
