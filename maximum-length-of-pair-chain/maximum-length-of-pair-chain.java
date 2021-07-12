class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> p1[1] - p2[1]);
        
        int max = Integer.MIN_VALUE;
        int count =0;
        
        for(int[] pair: pairs){
            if(max < pair[0]){
                max = pair[1];
                count++;
            }
        }
        return count;
    }
}