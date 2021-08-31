class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = new Comparator<>(){
             public int compare(Integer a, Integer b) {
                if (nums[a] != nums[b]) {
                    return Integer.compare(nums[a], nums[b]);
                }
                else {
                    return a - b;
                }
            } 
        };
        
        TreeSet<Integer> left = new TreeSet<>(comparator);
       
        TreeSet<Integer> right = new TreeSet<>(comparator);
        double[] medians = new double[nums.length - k + 1];
        int idx = 0;
        
        for(int i = 0; i < k; i++) {
            left.add(i);
        }
         // System.out.println(left);
        balance(left, right);
     // 0 1 3 
        
        medians[idx++] = getMedian(left, right, k, nums);
        
        for(int i = k, j = 0; i < nums.length; i++, j++) {
            if(!left.remove(j)) {
                right.remove(j);
            } 
            right.add(i);
            left.add(right.pollFirst());
            
            balance(left, right);
            // System.out.println(left + " \n" + right);
            medians[idx++] = getMedian(left, right, k, nums);
        }
        
        
        return medians;
    }
    
    private double getMedian(TreeSet<Integer> left, TreeSet<Integer> right, int k, int[] nums) {
        if((k & 1) == 0) {
            return ((double)nums[left.last()] + nums[right.first()])/2;
        }
        return (double) nums[right.first()];
    }
    
    private void balance(TreeSet<Integer> left, TreeSet<Integer> right) {
        while(left.size() > right.size()) {
            right.add(left.pollLast());
        }
    }
}