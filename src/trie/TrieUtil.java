package trie;

public class TrieUtil {
	public static final char[] ALPHABET = new char[] {
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
	};
	
	public static int getAlphabetIndex(char character) {
		for (int i = 0; i < ALPHABET.length; i++) 
			if (ALPHABET[i] == Character.toLowerCase(character)) 
				return i;
		
		return -1;
	}
}
