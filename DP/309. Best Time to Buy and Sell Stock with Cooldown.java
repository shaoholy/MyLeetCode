class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0; 
        }
        int[] rest = new int[prices.length];
        int[] buy = new int[prices.length];
        int[] sold = new int[prices.length];
        
        rest[0] = 0; 
        buy[0] = -prices[0]; 
        sold[0] = 0; 
        
        for (int i = 1; i < prices.length; i++) {
            rest[i] = Math.max(sold[i - 1], rest[i - 1]); 
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
            sold[i] = buy[i - 1] + prices[i]; 
        }
        return Math.max(sold[prices.length - 1], rest[prices.length - 1]);
    }
}