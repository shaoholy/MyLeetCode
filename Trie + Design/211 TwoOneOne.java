package Leetcode2;

public class TwoOneOne {

}
//TrieNode
//zhongdian! : this item should be "word". or as ""  
public class WordDictionary {
    public class TrieNode {
        public TrieNode[] children;
        public String item;
        public TrieNode(){
            this.item = "";
            this.children = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    public boolean search(String word) {
        return matchStr(word.toCharArray(), 0, root);
    }
    
    private boolean matchStr(char[] arr, int posi, TrieNode node){
        if(posi == arr.length){
            return !node.item.equals(""); //zhongdian! : this item should be "word". or as ""  
        }
        if(arr[posi] != '.'){
            if(node.children[arr[posi]-'a'] ==null){
                return false;
            }else{
                return matchStr(arr, posi + 1, node.children[arr[posi] - 'a']);
            }
        }else{
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null){
                    if(matchStr(arr, posi + 1, node.children[i])){
                        return true;
                    }
                }
            }
            return false; 
        }
    }
}