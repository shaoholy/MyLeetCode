class Solution {
    
    public void findSecretWord(String[] wordlist, Master master) {
        
        
        List<String> words = new ArrayList<>();
        for (String s : wordlist) {
            words.add(s);
        }
        
        for (int i = 0; i < 10; i++) {
            String s = pickGuess(words);
            int overlap = master.guess(s);
            if (overlap == 6) return;
            List<String> list = new ArrayList<>();
            for (String word : words) {
                if (match(word, s) == overlap) {
                    list.add(word);
                }
            }
            words = list;
        }
    }
    
    
    private String pickGuess(List<String> words) {
        int minMaxPeak = Integer.MAX_VALUE;
        String res = "";
        for (String word : words) {
            int curPeak = histogramPeak(word, words);
            if (curPeak < minMaxPeak) {
                minMaxPeak = curPeak;
                res = word;
            }
        }
        return res;
        
        // int max = Integer.MIN_VALUE;
        // String res = "";
        // for (String word : words) {
        //     int resSum = sumMatch(word, words);
        //     if (resSum > max) {
        //         max = resSum;
        //         res = word;
        //     }
        // }
        // return res;
    }
    
    private int histogramPeak(String word, List<String> words) {
        int[] hist = new int[7];
        for (String s : words) {
            hist[match(s, word)]++;
        }
        int maxPeak = 0;
        for (int num : hist) {
            maxPeak = Math.max(maxPeak, num);
        }
        return maxPeak;
    }
    
    private int sumMatch(String word, List<String> words) {
        int sum = 0; 
        for (String bword : words) {
            sum += match(word, bword); 
        }
        return sum; 
    }
        
    private int match(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}