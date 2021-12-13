# HuffmanCompression
An Implementation of the Huffman Compression Scheme in Java.

To use this program, enter the relative frequencies of the characters in the alphabet under consideration in a text file
in the directory ```data/freq_data```. This should be a text file with rows of the form "char: freq"
For instance, 
```
A: 7.01
G: 1.65
C: 4.01
T: 2.04
```
Enter the String which you would like to encode in a text file in the directory ```data/text```, and make a file in the same directory to write the encoded string to. Finally, to run the program, simply
```
javac -d bin -sourcepath src src/Huffman_Encoding/Driver.java
cd bin
java Driver path_to_freq_file path_to_text_file path_to_write_file
```
and the binary string encoding the given string will be written to the write file. For instance, to run the program with the current files, from the bin directory, run
```
java Huffman_Encoding.Driver ../data/freq_data/english_letter_frequencies.txt ../data/text/to_encode.txt ../data/text/encoded_string.txt
```
 To clean up the exectuables after running the program, simply
```
rm -r bin/Huffman_Encoding
```
