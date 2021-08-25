/* 
    @author: Nidhi
    
    Algorithm: Boyce Moore Voting Algorithm
    
    Time Complexity: O(N) + O(N)  --> 2 pass algorithm
    Space Complexity : O(1)

*/


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = -1, candidate2 = -1, count1 = 0, count2 = 0;
        
        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            }
            else if(num == candidate2) {
                count2++;
            }
            else if(count1 == 0) {
                count1++;
                candidate1 = num;
            }
            else if(count2 == 0) {
                count2++;
                candidate2 = num;
            }
            else {
                count1--;
                count2--;
            }
        }
        
        List<Integer> res = new ArrayList();
        count1 = 0;
        count2 = 0;
        
        for(int num : nums) {
            if(num == candidate1) count1++;
            else if(num == candidate2) count2++;
        }
        
        if(count1 > nums.length/3) res.add(candidate1);
        if(count2 > nums.length/3) res.add(candidate2);
        return res;
    }
}