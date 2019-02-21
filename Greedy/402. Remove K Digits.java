class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(); 
        if (k == num.length()) {
            return "0"; 
        }
        for (int i = 0; i < num.length(); i++) {
            char cur = num.charAt(i); 
            sb.append(cur);
            while (sb.length() > 0 && k > 0 && (i == num.length() - 1 || sb.charAt(sb.length() - 1) - num.charAt(i + 1) > 0)){
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
        }
        
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}