class Solution {
    public boolean backspaceCompare(String S, String T) {
        int idxS = S.length() - 1, idxT = T.length() - 1; 
        
        while (true) {
            for (int backNum = 0; idxS >= 0 && (backNum > 0 || S.charAt(idxS) == '#'); idxS--) {
                backNum += (S.charAt(idxS) == '#') ? 1 : -1; 
            }
            for (int backNum = 0; idxT >= 0 && (backNum > 0 || T.charAt(idxT) == '#'); idxT--) {
                backNum += (T.charAt(idxT) == '#') ? 1 : -1; 
            }
            if (idxS >= 0 && idxT >= 0 && S.charAt(idxS) == T.charAt(idxT)) {
                idxS--; 
                idxT--; 
            } else {
                return idxS == -1 && idxT == -1; 
            }
        }
    }
}