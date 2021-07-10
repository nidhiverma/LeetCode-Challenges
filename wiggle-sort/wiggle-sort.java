class Solution {
    public void wiggleSort(int[] nums) {
        boolean inc = true;
        
        for(int i = 1; i < nums.length; i++) {
            if(inc) {
                if(nums[i] < nums[i-1]) {
                    swap(nums, i, i-1);
                }
            }
            else if(!inc) {
                if(nums[i] > nums[i-1]) {
                    swap(nums, i, i-1);
                }
            }
            
            inc = !inc;
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}