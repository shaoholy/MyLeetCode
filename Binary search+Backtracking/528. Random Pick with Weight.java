class Solution {
    private int overall; 
    private Random rd = new Random(); 
    private TreeMap<Integer, Integer> map = new TreeMap<>(); 

    public Solution(int[] w) {
        for (int i = 0; i < w.length; i++) {
            map.put(overall, i); 
            overall += w[i]; 
        }
    }
    
    public int pickIndex() {
        int idx = rd.nextInt(overall); 
        return map.floorEntry(idx).getValue(); 
    }
}