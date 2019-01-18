class Solution {
    Map<String, List<Integer>> valMap = new HashMap<>(); 
    public int evaluate(String expression) {
        return eval(expression, new HashMap<String, Integer>());
    }
    
    private int eval(String expression, Map<String, Integer> parent) {
        //case 1: single value/expr
        if (expression.charAt(0) != '(') {
            if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-') {
                return Integer.parseInt(expression);
            }
            return parent.get(expression);
        }
        
        //case 2: multiple (start and end with ( & )) 
        Map<String, Integer> newMap = new HashMap<>();
        newMap.putAll(parent); 
        List<String> tokens = parse(expression.substring(expression.charAt(1) == 'm' ? 6 : 5, expression.length() - 1));
        int res; 
        if (expression.charAt(1) == 'm') {
            return eval(tokens.get(0), newMap) * eval(tokens.get(1), newMap);
        } else if (expression.charAt(1) == 'a') {
            return eval(tokens.get(0), newMap) + eval(tokens.get(1), newMap);
        } else {
            for (int i = 0; i < tokens.size() - 2; i += 2) {
                newMap.put(tokens.get(i), eval(tokens.get(i + 1), newMap));
            }
            return eval(tokens.get(tokens.size() - 1), newMap);
        }
        
    }
    
    private List<String> parse(String expression) {
        List<String> res = new ArrayList<>(); 
        int lev = 0; 
        StringBuilder sb = new StringBuilder(); 
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                lev++;
            }
            if (c == ')') {
                lev--;
            }
            if (c == ' ' && lev == 0) {
                res.add(sb.toString());
                sb.delete(0, sb.length());
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
                res.add(sb.toString());
        }
        return res; 
    }
}