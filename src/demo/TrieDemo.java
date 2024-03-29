package demo;
import trie.*;
import java.util.ListIterator;

public class TrieDemo {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.add("Anand");
		trie.add("Ana");
//		trie.add("Pluot");
//		trie.add("Mangosteen");
//		trie.add("Mango");
//		trie.add("Nectarine");
//		trie.add("Grape");
		trie.delete("Anand");

		trie.traverse();

		String[] dictionary = trie.generateDictionary();
		DisplayUtil.printArray(dictionary);
	}
}
