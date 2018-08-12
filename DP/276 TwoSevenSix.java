package Leetcode2;

public class TwoSevenSix {
	public static void main(String[] args) {
		TwoSevenSix tss=new TwoSevenSix();
		System.out.println(tss. numWays(5, 7));
		System.out.println(tss.numWays2(5, 7));
		System.out.println(tss.numWays3(5, 7));
	}
	
    public int numWays2(int n, int k) {
        if (n == 0 || k == 0)
            return 0;
        if (n == 1)
            return k;
        int same_count = k;
        int differ_count = k * (k - 1);
        for (int i = 3; i <= n; i++) {
            int temp = differ_count;
            differ_count = differ_count * (k - 1) + same_count * (k - 1);
            same_count =  temp;
        } 
        return same_count + differ_count;
    }
    

    public int numWays3(int n, int k) {
        int[] f = new int[n + 1];
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        f[0] = k;
        f[1] = k * k;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] * (k - 1) + f[i - 2] * (k - 1);
        }
        return f[n - 1];
    }
}

