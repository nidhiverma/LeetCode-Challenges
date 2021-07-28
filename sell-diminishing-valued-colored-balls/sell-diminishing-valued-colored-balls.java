class Solution {
    public int maxProfit(int[] inventory, int orders) {
        long res = 0, colors = 1;
        int mod = (int) (1e9+7);
        
        Arrays.sort(inventory);
        
        for (int i = inventory.length - 1; i >= 0 && orders > 0; --i, ++colors) {
            long cur = inventory[i];
            long prev = i > 0 ? inventory[i - 1] : 0;
            long rounds = Math.min(orders / colors, cur - prev);
            orders -= rounds * colors;
            res = (res + (cur * (cur + 1) - (cur - rounds) * (cur - rounds + 1)) / 2 * colors) % mod;
            if (cur - prev > rounds) {
                res = (res + orders * (cur - rounds)) % mod;
                break;
            }
        }
        return (int)res;        
        

// TLE
//         PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
//         int maxProfit = 0, mod = (int)(1e9+7);
        
//         for(int price : inventory) {
//             pq.offer(price);
//         }
     
//         while(orders-- > 0 && !pq.isEmpty()) {
//             int price = pq.poll();
//             maxProfit = (maxProfit + price) % mod;
//             pq.offer(price-1);
//         }
//         return maxProfit;
    }
}