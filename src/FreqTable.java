import java.util.Map;
import java.util.HashMap;
public class FreqTable {
    private Map<Character, Double> freqTable;
    /**
     * A simply wrapper class for a Hashmap 
     * representing the frequencies of characters in our alphabet
     */
    public FreqTable() {
        this.freqTable = new HashMap<Character, Double>();
    }

    /**
     * @return A deep copy of the frequency table
     */
    public Map<Character, Double> getFreqTable() {
        Map<Character, Double> freqTableClone = new HashMap<Character, Double>();
        for(Map.Entry<Character, Double> entry : this.freqTable.entrySet()) {
            freqTableClone.put(entry.getKey(), entry.getValue());
        }

        return freqTableClone;
    }

    /**
     * Add a character to the frequency table with a given frequency
     * @param c The character to be added
     * @param freq The frequency of this character
     * @throws IllegalArgumentException if the character is already in the Hashmap
     */
    public void addCharacter(char c, double freq) throws IllegalArgumentException {
        if(this.freqTable.containsKey(c)) {
            throw new IllegalArgumentException("Character is already present in Frency Table");
        }
        this.freqTable.put(c, freq);
    }

    /**
     * Updates the frequency of a given character and 
     * @param c The character which we want to udpate the frequency of
     * @param freq The new frequency of the character
     * @throws IllegalArgumentException if the character does not exist
     */
    public void updateFreq(char c, double freq) throws IllegalArgumentException {
        if(!this.freqTable.containsKey(c)) {
            throw new IllegalArgumentException("Character is not present in Frequency Table");
        }
        this.freqTable.put(c, freq);
    }

    /**
     * Displays the frequency table in the form "char: val".
     * E.g. if the character 'c' appears with frequency 3, displays "c: 3"
     */
    public void print() {
        for(Map.Entry<Character, Double> entry : this.freqTable.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
