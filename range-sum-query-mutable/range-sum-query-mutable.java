class NumArray {
    private int[] nums;
    private int[] blockSum;
    private int len;

    public NumArray(int[] nums) {
        this.nums = nums;
        double l = Math.sqrt(nums.length);
        this.len = (int)Math.ceil(nums.length/l);
 
        blockSum = new int[len];
        
        for(int i = 0; i < nums.length; i++) {
            blockSum[i/len] += nums[i];
        }
    }

    public void update(int index, int val) {
        int block_num = index/len;
        blockSum[block_num] += val-nums[index];
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int startBlock =  left/len;
        int endBlock = right/len;
        int sum = 0;
        
        if(startBlock == endBlock) {
            for(int k = left; k <= right; k++) {
                sum += nums[k];
            }
        }
        else {
            // left ---> firstBlockEnd
            for(int k = left; k <= (startBlock+1)*len-1; k++) {
                sum += nums[k];
            }
            // secondBlock --> lastSecondBlock
            for(int k = startBlock+1; k <= endBlock-1; k++) {
                sum += blockSum[k];
            }
            // lastBlockStart --> right
            for(int k = endBlock*len; k <= right; k++) {
                sum += nums[k];
            }
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */