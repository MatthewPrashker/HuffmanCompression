package Huffman_Encoding;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
    	String encoding_file = "";
    	String text_file = "";
    	String to_encode = "";
    	FreqTable frequencies = new FreqTable();
    	try {
    		encoding_file = args[0];
    	    text_file = args[1];
    	} catch(ArrayIndexOutOfBoundsException e) {
    		System.out.println("Enter Frequency File followed by Text to Encode f");
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
    	
    	HTree HuffmanTree = new HTree(frequencies);
    	System.out.println(HuffmanTree.encode(to_encode));
    	System.out.println(HuffmanTree.decode(HuffmanTree.encode(to_encode)));
    	
    	
    }
}
