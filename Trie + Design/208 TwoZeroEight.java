package Leetcode2;

public class TwoZeroEight {

}
//1 TrieNode
class TrieNode{
    boolean isWord;
    TrieNode[] children;
    public TrieNode(){
        this.isWord = false; 
        this.children = new TrieNode[26];
    }
}
public class Trie {
TrieNode root; 

/** Initialize your data structure here. */
	public Trie() {
	    this.root = new TrieNode(); 
	}
	
	/** Inserts a word into the trie. */
	public void insert(String word) {
	    TrieNode node = this.root; 
	    for(char c: word.toCharArray()){
	        if(node.children[c-'a'] == null){
	            node.children[c-'a'] = new TrieNode();
	        }
	        node = node.children[c-'a']; 
	    }
	    node.isWord = true; 
	}
	
	/** Returns if the word is in the trie. */
	public boolean search(String word) {
	    TrieNode node = this.root; 
	    for(char c: word.toCharArray()){
	        if(node.children[c - 'a'] == null){
	            return false; 
	        }
	        node = node.children[c - 'a']; 
	    }
	    return node.isWord; 
	}
	
	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
	    TrieNode node = this.root; 
	    for(char c: word.toCharArray()){
	        if(node.children[c - 'a'] == null){
	            return false; 
	        }
	        node = node.children[c - 'a'];
	    }
	    if(node.isWord){
	        return true; 
	    }else{
	        for(int i = 0; i < 26; i++){
	            if(node.children[i] != null){
	                return true;
	            }
	        }
	        return false; 
	    }
	}
}