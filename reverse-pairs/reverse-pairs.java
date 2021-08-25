class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    private int mergeSort(int[] nums, int left, int right) {
        if(left >= right) return 0;
        
        int mid = left + (right - left)/2;
        
        int inv = mergeSort(nums, left, mid);
        inv += mergeSort(nums, mid+1, right);
        inv += merge(nums, left, mid, right);
        
        return inv;
    }
    
    private int merge(int[] nums, int left, int mid, int right) {
        int count  = 0, j = mid+1, i = 0;
        
        for(i = left; i <= mid; i++) {
            while(j <= right && nums[i] > 2*(long)(nums[j])) {
                j++;
            }
            count += (j-(mid+1));                
        }
        
        List<Integer> temp = new ArrayList();
        i = left;
        j = mid+1;
        
        while(i <= mid && j <= right) {
            if(nums[i] <= nums[j]) {
                temp.add(nums[i++]);
            }
            else {
                temp.add(nums[j++]);
            }
        }
        
        while(i <= mid) {
            temp.add(nums[i++]);
        }
        while(j <= right) {
            temp.add(nums[j++]);
        }
        
        for(i = left; i <= right; i++) {
            nums[i] = temp.get(i-left);
        }
        return count;
    }
}