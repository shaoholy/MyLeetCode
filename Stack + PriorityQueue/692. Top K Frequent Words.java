class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>(); 
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1); 
        }
        
        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>(){
            public int compare(String a, String b) {
                int aNum = map.get(a); 
                int bNum = map.get(b); 
                if (aNum != bNum) {
                    return bNum - aNum;
                } else {
                    return a.compareTo(b); 
                }
            }
        });
        for (String key: map.keySet()) {
            heap.add(key);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(heap.poll());
        }
        return res; 
    }
}