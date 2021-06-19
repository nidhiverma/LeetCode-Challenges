/*
    @author: Nidhi Verma
    
    Brute Force:
        Consider all subsequences, and check for condition
        Time Complexity: O(2^n)
        Space Complexity: O(1)
        
    Efficient Approach: 
        Sort the array, use two-pointers
        i = 0, j = len-1
        
        if sum([i] + [j])  <= target:
                ---> add all the possible subsequences from (i+1 to j)
                i++
        else:
            j--
        
        Time Complexity: O(n)
        Space Complexity: O(1)
        
        
        
*/
class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = (int)(1e9 + 7);
        
        long[] power = new long[nums.length];
        power[0] = 1;
        
        for(int i = 1; i < nums.length; i++) {
            power[i] = (power[i-1] * 2) % mod;
        }
        
        int i = 0, j = nums.length-1;
        long count = 0;
        
        while(i <= j) {
            int sum = nums[i] + nums[j];
            
            if(sum <= target) {
                int exp = j-i;
                count += power[j-i] % mod;
                i++;
            }
            else {
                j--;
            }
        }
        
        return (int)(count % mod);
    }
}