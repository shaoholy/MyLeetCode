package Leetcode;

public class OneSeven {

}
//O(k^n) time (k maplist length average, n digits length). Normal bt. 
class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, List<Character>> map=new HashMap<>();
        map.put(2, Arrays.asList('a', 'b','c'));
        map.put(3, Arrays.asList('d', 'e','f'));
        map.put(4, Arrays.asList('g', 'h','i'));
        map.put(5, Arrays.asList('j', 'k','l'));
        map.put(6, Arrays.asList('m', 'n','o'));
        map.put(7, Arrays.asList('p', 'q','r','s'));
        map.put(8, Arrays.asList('t', 'u','v'));
        map.put(9, Arrays.asList('w', 'x','y','z'));
        ArrayList<String> res=new ArrayList<String>();
        if(digits==null || digits.length()==0) return res;
        bt17(new StringBuilder(), digits, map, res);
        return res;
    }
    private void bt17(StringBuilder cur,String digits,
                      HashMap<Integer,List<Character>> map,ArrayList<String> res){
        if(cur.length()==digits.length()){
            res.add(new String(cur));
            return; 
        }
        int curlen=cur.length();
        for(char x: map.get(digits.charAt(curlen)-'0')){
            cur.append(x);
            bt17(cur, digits, map, res);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
//2, queue bfs iteration method
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<String>();
		if(digits.isEmpty()) return res;
		String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		res.add("");
        for(int i=0; i<digits.length(); i++){
            int len=res.size();
            for(int j=0; j<len; j++){
                String oldstr=res.poll();
                for(int k=0; k<map[digits.charAt(i)-'0'].length(); k++){
                    String newstr=oldstr+map[digits.charAt(i)-'0'].charAt(k);
                    res.add(newstr);
                }
            }
        }
        return res;
    }
}