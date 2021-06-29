/*
    @author: Nidhi
    
    Approach1:
        Since all the nums are in the range (1, n)
        Maintain an extra array of size nums.length. Mark the value at index nums[i]-1 as -1 in this array.
        eg: [1,3,3]  ===> [-1,3,-1]
        Now traverse this new array, all the indexes where val != -1 are the missing numbers
        add them to the result list
        Here, nums[1] != -1, hence add 1+1 = 2 to the list
        
        Time Complexity: O(n)
        Space Complexity: O(n)
        
    Approach2: 
        Instead of creating a new array, we can do it inplace
        Negate the numbers already seen.
        To check if a number is already seen, 
            check nums[abs(nums[i])-1] < 0:
                if yes: continue
                otherwise: set nums[abs(nums[i])-1] *= 1 (negate it)
        
        Traverse the whole array once again, indexes with positive values are the missing values
        
        Time Complexity: O(n)
        Space Complexity: O(n)
        
    Approach2: Two Pointers
        i --> represents next unique number
        j --> index in nums array
        
        for j in [0,len-1]:
            if curr num == next unique num, increase i and j
            elif curr num < next unique num, skip curr element and increase j\
            elif curr num > next unique num, add all the unique nums in the range [i,j)
        
        add all the remaining unique nums in the range [i,j]
        eg: [1,1,1,1]
            i = 2
            j = 4
            add (2,3,4)
            
        Time Complexity: O(n)
        Space Complexity: O(1)
        
    
        
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList();
     
        /* APPROACH 3 */
    
        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) -1;
            if(nums[idx] > 0) nums[idx] *= -1;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
        
        /* 
        APPROACH 2
        
        
        Arrays.sort(nums);
        int i = 1, j = 0;
        
        while(j < nums.length) {
            if(nums[j] == i) {
                i++;
                j++;
            }
            else if(nums[j] < i) {
                j++;
            }
            else {
                while(i < nums[j]) {
                    res.add(i++);
                }
            }
        }
        
        while(i <= j) {
            res.add(i++);
        }
        return res;
        
        
        APPROACH 1 
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[nums[i]-1] = -1;
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != -1) {
                res.add(i+1);
            }
        }
        */
        
        
    }
}

