package trie;

import java.util.LinkedList;
import java.util.ListIterator;

public class TrieNode {
	public char key; //
	public LinkedList<TrieNode> associates;
	public boolean complete = false;

    TrieNode(char character) {
        key = character;
        associates = new LinkedList<>();
    }
    
    public void addChild(TrieNode node) {
    	associates.addFirst(node);
    }
    
    public boolean hasChild() {
    	return associates.size() > 0;
    }
    
    public TrieNode findChild(char character) {
        ListIterator<TrieNode> iter = associates.listIterator();
        
        while (iter.hasNext()) {
            TrieNode child = (TrieNode) iter.next();
            
            if (child.key == character)
                return child;
        }
        
        return null;
    }
    
    public void deleteChild(TrieNode child) {
    	associates.remove(child);
    }
    
    public void displayKey() {
    	System.out.print(key + " ");
    }
}
