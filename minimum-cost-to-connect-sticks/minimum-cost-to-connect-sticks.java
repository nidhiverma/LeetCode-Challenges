class Solution {
    public int connectSticks(int[] sticks) {
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int stick: sticks) pq.offer(stick);
        
        while(pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            cost += sum;
            pq.offer(sum);
        }
        return cost;
    }
}