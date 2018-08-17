package Leetcode2;

public class TwoOneTwo {

}
///1, Trie + DFS
class Solution {
    List<String> res; 
    final int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}}; 
    public List<String> findWords(char[][] board, String[] words) {
        Trie dict = new Trie();
        for(String word: words){
            dict.insert(word);
        }
        res = new ArrayList<String>(); 
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if(dict.root.children[board[i][j] - 'a'] != null){
                    boolean[][] vis = new boolean[board.length][board[0].length];
                    vis[i][j] = true; 
                    dfs(board, vis, new String() + board[i][j], i, j, dict.root.children[board[i][j] - 'a']); 
                }
            }
        }
        return res;
    }
    
    private void dfs(char[][] board, boolean[][] vis, String cur, int r, int c, TrieNode node){
        if(node.isWord){
            res.add(cur);
            node.isWord = false; 
        }
        
        for(int i = 0; i < 4; i++){
            int nextr = r + dir[i][0];
            int nextc = c + dir[i][1];
            if(nextr >= 0 && nextr < board.length && nextc >= 0 && nextc < board[0].length && 
              !vis[nextr][nextc] && node.children[board[nextr][nextc] - 'a'] != null){
                vis[nextr][nextc] = true; 
                dfs(board, vis, cur+board[nextr][nextc], nextr, nextc, node.children[board[nextr][nextc] - 'a']);
                vis[nextr][nextc] = false;
            }
        }
    }
}

class Trie{
    TrieNode root; 
    public Trie() {
      this.root = new TrieNode(); 
    }   
    
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
}


class TrieNode{
    boolean isWord;
    TrieNode[] children;
    public TrieNode(){
        this.isWord = false; 
        this.children = new TrieNode[26];
    }
}