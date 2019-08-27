package trie;

import java.util.LinkedList;

public class Trie {
	public TrieNode root;
	private LinkedList<String> dictionary;
	
	public Trie() {
		root = new TrieNode(' ');
	}
	
	public void add(String word) {
		TrieNode current = root; // start w/ root node
		TrieNode existed = null;
		
		// iterate thru all characters in the word
		for (char character: word.toCharArray()) {
			existed = current.findChild(character);

			// EITHER current node has no children
			// OR the character did not exist already
			// -> add new entry to current node
			// -> set new entry as current node
			if (!current.hasChild() || existed == null) {
				TrieNode newEntry = new TrieNode(character);
				current.addChild(newEntry);
				current = newEntry;

				// if existed -> set existed node as current and continue on checking
			} else 
				current = existed;
		}

		// EITHER 1. if the last character was added AND the current node has no child
		//	-> a complete word has been added in the trie
		//	-> therefore mark the node as completed
		// OR 2. if the last checked character already exist in a node with children
		// 	-> the character is part of longer word but it also is a complete word standalone
		// 	-> therefore mark the existing node as complete
		if ((current != null && !current.hasChild()) || (current == existed && current.hasChild())) 
			current.complete = true; 
	}
	
	public void delete(String word) {
		delete(word, root, 0);
	}
	
	// Start at root level, traverse down the trie and recurringly delete character until the last is reached
	// Before removal, ensure the character is NOT a part of another word, therefore is okay to remove
	// If any character cannot be deleted, the operation should return false and terminate
	private boolean delete(String word, TrieNode current, int level) {
		// if the level is the same as the number of character in the word
		//	-> we reached the last character
        if (level == word.length()) {
            // if the node of the last character is not marked complete
        	//	-> the last character is part of another word
        	//	-> therefore we cannot delete the specified word that is associated with other word
            if (!current.complete) 
            	return false;
            
            //if last character is a complete word 
            //-> we need to mark it partial and start deleting the character upward
            current.complete = false;
            return !current.hasChild();
        }
        
        //look for the node that contains the character of current level
        TrieNode child = current.findChild(word.charAt(level));

        if (child == null) 
        	return false;
        
        boolean canDelete = delete(word, child, level + 1);
        
        if (canDelete) {
            current.deleteChild(child);
            return !current.hasChild();
        }
        
        return false;
	}
	
	/**
	 * @desc	check and return the status of any given word
	 * @return	"not found" | "complete" | "partial"
	 */
	public String checkStatus(String word) {
		TrieNode current = root;

		for (char character: word.toCharArray()) {
			TrieNode existed = current.findChild(character);

			if (existed == null)
				return "not found";

			current = existed;
		}
		
		return current.complete ? "complete" : "partial";
	}

    public void traverse() {
        TrieNode current = root;
        TrieNode[] associates = current.associates.toArray(new TrieNode[current.associates.size()]);
        
        for (TrieNode member: associates)
            traverse(member, "");
    }

    private void traverse(TrieNode node, String output) {
        TrieNode[] associates = node.associates.toArray(new TrieNode[node.associates.size()]);
        output += node.key;
        
        node.displayKey();
        
        if (node.complete) 
        	System.out.println(". " + output);

        if (associates.length > 0)
        	for (TrieNode member: associates) 
        		traverse(member, output);
    }

    /**
     * @desc 	traverse thru the trie, for each complete word found, add it to list
     * @return	String[] a list of complete words found in the trie
     */
    public String[] generateDictionary() {
        TrieNode current = root;
        TrieNode[] associates = current.associates.toArray(new TrieNode[current.associates.size()]);
        dictionary = new LinkedList<>();
        
        for (TrieNode member: associates)
            generateDictionary(member, "");
        
        return dictionary.toArray(new String[dictionary.size()]);
    }

    private void generateDictionary(TrieNode node, String output) {
        TrieNode[] associates = node.associates.toArray(new TrieNode[node.associates.size()]);
        output += node.key;
        
        if (node.complete) 
        	dictionary.offer(output);

        if (associates.length > 0)
        	for (TrieNode member: associates) 
        		generateDictionary(member, output);
    }
}
