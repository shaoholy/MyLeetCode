class AutocompleteSystem {
    Map<String, Integer> strToTimes = new HashMap<>();
    TrieNode root = new TrieNode(); 
    StringBuilder sb = new StringBuilder(); 
    TrieNode current; 

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < times.length; i++) {
            strToTimes.put(sentences[i], times[i]); 
            pushToTrie(sentences[i]); 
        }
        current = root; 
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>(); 
        if (c == '#') {
            String cur = sb.toString();
            sb.delete(0, sb.length());
            if (!strToTimes.containsKey(cur)) {
                pushToTrie(cur); 
            }
            strToTimes.put(cur, strToTimes.getOrDefault(cur, 0) + 1);
            current = root; //reset current node to root;
            return res; 
        } else {
            sb.append(c);
            PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
                if (strToTimes.get(a) != strToTimes.get(b)) {
                    return strToTimes.get(b)- strToTimes.get(a);
                } else {
                    return a.compareTo(b); 
                }
            });
            //getStrWithPrefix(sb, heap); 
            getWithChar(c, heap);
            for (int i = 0; i < 3 && !heap.isEmpty(); i++) {
                res.add(heap.poll());
            }
            return res; 
        }
    }
    
    private void pushToTrie(String str) {
        TrieNode curNode = root; 
        for (char c : str.toCharArray()) {
            curNode.strsWithCurPrefix.add(str); 
            //System.out.println(str);
            if (!curNode.children.containsKey(c)) {
                curNode.children.put(c, new TrieNode());
            }
            curNode = curNode.children.get(c); 
        }
        curNode.strsWithCurPrefix.add(str); 
    }
    
    private void getStrWithPrefix(StringBuilder sb, PriorityQueue<String> heap) {
        TrieNode node = root; 
        for (char c : sb.toString().toCharArray()) {
            node = node.children.get(c); 
            if (node == null) {
                return; 
            }
        }
        heap.addAll(node.strsWithCurPrefix);
        return; 
    }
    
    private void getWithChar(char c, PriorityQueue<String> heap) {
        if (current == null || !current.children.containsKey(c)){
            current = null; 
            return;
        }
        
        heap.addAll(current.children.get(c).strsWithCurPrefix);
        current = current.children.get(c);
        return; 
    }
}

class TrieNode {
    Map<Character, TrieNode> children; 
    Set<String> strsWithCurPrefix; 
    
    public TrieNode() {
        this.children = new HashMap<>(); 
        this.strsWithCurPrefix = new HashSet<>();
    }    
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */