class Solution {
    
    HashMap<String, Integer> map = new HashMap();
    
    public int maxProfit(int k, int[] prices) {
        return helper(prices, k, 0, 0); 
    }
    
    private int helper(int[] prices, int k, int day, int stockInHand) {
        if(day >= prices.length || k <= 0) return 0;
        
        
        String key = "" + k + " " + day + " " + stockInHand;
        if(map.containsKey(key)) return map.get(key);
        
        int maxProfit = 0;
        
        if(stockInHand == 0) {
            maxProfit = Math.max(helper(prices, k, day+1, 1)-prices[day], helper(prices, k, day+1, 0));
        }
        
        else {
            maxProfit = Math.max(helper(prices, k-1, day+1, 0)+prices[day], helper(prices, k, day+1, 1));
        }
        
        map.put(key, maxProfit);
        return maxProfit;
    }
}