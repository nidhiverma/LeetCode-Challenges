class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length == 1) return nums;
        int mid = nums.length/2;
        int[] arr1 = buildArray(nums, 0, mid);
        int[] arr2 = buildArray(nums, mid, nums.length);
        
        arr1 = sortArray(arr1);
        arr2 = sortArray(arr2);
        return merge(arr1, arr2);
    }
    
    private int[] merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int l1 = arr1.length, l2 = arr2.length;
        
        int[] sortedArray = new int[l1 + l2];
        
        while(i < l1 && j < l2) {
            if(arr1[i] <= arr2[j]) sortedArray[k++] = arr1[i++];
            else sortedArray[k++] = arr2[j++];
        }
        while(i < l1) sortedArray[k++] = arr1[i++];
        while(j < l2) sortedArray[k++] = arr2[j++];
        return sortedArray;
    }
    
    private int[] buildArray(int[] nums, int lo, int hi) {
        int[] arr = new int[hi-lo];

        for(int i = lo, k = 0; i < hi; i++) {
            arr[k++] = nums[i];
        }
        return arr;
    }
}