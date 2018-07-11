package Leetcode;

public class SixZero {

}
//o(n) solution zhongdian: 除法取商取余的时候，要注意余数为0的时候通常为corner case需特殊考虑。
class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> thelist=new ArrayList<Integer>();
        String res="";
        if(n==1) return res+1;
        
        for(int i=1; i<=n; i++) thelist.add(i);
        
        for(int i=1; i<n; i++){
            int thisfactor=getNjie(n-i);
            int thisposi=k/thisfactor;
            k=k%thisfactor;
            if(k==0){
                res+=thelist.get(thisposi-1);
                thelist.remove(thisposi-1);
                while(thelist.size()!=0){
                    res+=thelist.get(thelist.size()-1);
                    thelist.remove(thelist.size()-1);
                }
                return res;
            }
            res+=thelist.get(thisposi);
            thelist.remove(thisposi);
        }
        return res;
    }
    private int getNjie(int n){
        int r=1;
        for(int i=n; i>=2; i--) r*=i;
        return r;
    }
}

//2, improved. 1, use int[] to do the n! function, faster; 2, use (k-1) to do division to avoid corner case
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new LinkedList<Integer>();
        StringBuilder s = new StringBuilder();
        int[] factorial = new int[n+1];
        int index = 0;
        factorial[0] = 1;
        


        for(int i = 1; i <= n; i++) {
            list.add(i);
            factorial[i] = factorial[i - 1] * i;
        }

        for(int i = n; i >= 1; i--) {
            index = (k - 1) % factorial[i] / factorial[i - 1];
            s.append(list.get(index));
            list.remove(index);
        }
        return s.toString();
    }

}