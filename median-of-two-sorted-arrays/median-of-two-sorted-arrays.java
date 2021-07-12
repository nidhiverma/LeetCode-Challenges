class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        
        if(m > n) return findMedianSortedArrays(nums2, nums1);
        
        boolean isEven = (m+n) % 2 == 0;
        
        int lo = 0, hi = nums1.length;
        
        while(lo <= hi) {
            int cut1 = lo + (hi-lo)/2;
            int cut2 = (m+n)/2 - cut1;
            
            int l1 = cut1 > 0 ? nums1[cut1-1] : Integer.MIN_VALUE;
            int l2 = cut2 > 0 ? nums2[cut2-1] : Integer.MIN_VALUE;
            int r1 = cut1 < m ? nums1[cut1] : Integer.MAX_VALUE;
            int r2 = cut2 < n ? nums2[cut2] : Integer.MAX_VALUE;
            
            if(l1 <= r2 && l2 <= r1) {
                if(isEven) {
                    return ((double)(Math.max(l1, l2)) + Math.min(r1, r2))/2.0;
                }
                else {
                    return Math.min(r1, r2);
                }
            }
            else if(l1 > r2) {
                hi = cut1 - 1;
            }
            else { 
                lo = cut1 + 1;
            }
        }
        return 0;
    }
}