# HuffmanCompression
An Implementation of the Huffman Compression Scheme in Java

To use this program, enter the relative frequencies of the characters in the alphabet under consideration in a text file
in the directory ```data/freq_data```. This should be a text file with rows of the form "char: freq"
For instance, 
```
A: 7.01
G: 1.65
C: 4.01
T: 2.04
```
Enter the String which you would like to encode in a text file in the directory ```data/text```. Finally, to run the program, simply
```
javac src/Driver.java
java Driver path_to_freq_file path_to_text_file
```
and the binary string encoding the given string will be displayed. To clean up the exectuables after running the program, simply
```
rm src/*.class
```
