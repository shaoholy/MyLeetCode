class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n); 
        long higherPal = findPal(num + 1, true); 
        long lowerPal = findPal(num - 1, false);
        
        return higherPal - num < num - lowerPal ? String.valueOf(higherPal) : String.valueOf(lowerPal);
    }
    
    private void replicateFirstHalf(char[] base) {
        for (int i = base.length - base.length / 2; i < base.length; i++) {
            base[i] = base[base.length - 1 - i]; 
        }
    }
    
    private long findPal(long input, boolean up) {
        int inc = up ? 1 : -1; 
        char[] original = String.valueOf(input).toCharArray(); 
        char[] base = original.clone(); 
        replicateFirstHalf(base); 
        
        for (int i = 0; i < original.length; i++) {
            if ((up && base[i] > original[i]) || (!up && base[i] < original[i])) {
                return Long.parseLong(String.valueOf(base));
            } else if ((up && base[i] < original[i]) || (!up && base[i] > original[i])) {
                for (int j = (original.length - 1) / 2; j >= 0; j--) {
                  if (base[j] + inc < '0' || base[j] + inc > '9') {
                    base[j] = '0';
                  } else {
                    base[j] += inc;
                    break;
                  }
                }
                if (base[0] == '0') {
                  char[] temp = new char[base.length - 1];
                  Arrays.fill(temp, '9');
                  return Long.parseLong(String.valueOf(temp));
                }
                replicateFirstHalf(base);
                return Long.parseLong(String.valueOf(base));
            }
        }
        return Long.parseLong(String.valueOf(base));
    }
}