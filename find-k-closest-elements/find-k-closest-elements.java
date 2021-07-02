class Solution {
    class Pair {
        int val, diff;
        public Pair (int val, int diff) {
            this.val = val;
            this.diff = diff;
        }
    }
    class PairComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return b.diff - a.diff;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue(new PairComparator());
        
        for(int i = 0; i < arr.length; i++) {
            int diff =  Math.abs(arr[i] - x);
            if(pq.size() < k) {
                pq.offer(new Pair(arr[i], diff));
            }
            else {
                if(pq.peek().diff > diff) {
                    pq.poll();
                    pq.offer(new Pair(arr[i], diff));
                }
            }
        }
        
        List<Integer> res = new ArrayList();
        while(pq.size() > 0) {
            res.add(pq.poll().val);
        }
        Collections.sort(res);
        return res;
    }
}