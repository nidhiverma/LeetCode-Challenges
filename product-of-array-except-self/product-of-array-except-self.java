/*
    @author: Nidhi and Iti
    
    Approach 1: 
        Maintain 2 arrays ---> prefix product array and suffix product array
        for num[i], product except itself = prefixProduct[i] * suffixProduct[i]
        
        Time Complexity: O(n)
        Space Complexity: O(n)
        
    Approach 2:
        Instead of maintaining 2 arrays, keep only 1 array with prefix products
        traverse prefix array in reverse order and calculate suffix product on the go.
        suffix product = 1 (initially)
        for ith num, suffix product = suffix product * nums[i+1]
        res[i] = prefixProduct[i] * suffixProduct
        
        Time Complexity: O(n)
        Space Complexity: O(1)
        
     Approach 3:
        Use the logarithm property: log(a / b) = log(a) - log(b)
                                   a/b = e^(log(a) - log(b))
        a will be the product and b will be the number which is not supposed to be multiplied
        So, for every number in the array, we have to find e^(log(prod) - log(num))
        In this, we have to handle some edge cases-> for negative numbers and for zeros
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1, zeros = 0, sign = 1;
        
        for(int num: nums) {
            if(num == 0) {
                zeros++;
                continue;
            }
            product *= num;
        }
        
        sign = product < 0 ? -1 : 1;
        product = Math.abs(product);
            
        int[] result = new int[nums.length];
        
        if(zeros > 1) {
            return result;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                result[i] = sign * product;
                break;
            }
            
            else if(zeros == 0){
                double logProd = Math.log(product);
                double logNum = Math.log(Math.abs(nums[i]));
                result[i] = (int)(Math.round(Math.exp(logProd - logNum)));
                
                //If product is -ve and nums[i] is +ve or vice versa      
                if(sign > 0 ^ nums[i] > 0){ 
                    result[i] *= -1;                       
                }
            }
            
        }
        return result;
        
        
//         // 1 1 2 6
        
//         // suffix = 1
//         // 24 12 8 6       suffix = 12 * 2
        
//         int[] prefixProduct = new int[nums.length];
        
//         prefixProduct[0] = 1;
        
//         for(int i = 1; i < nums.length; i++) {
//             prefixProduct[i] = prefixProduct[i-1]*nums[i-1];
//         }
        
//         int suffixProduct = 1;
//         for(int i = nums.length-1; i >= 0; i--) {
//             prefixProduct[i] = prefixProduct[i] * suffixProduct;
//             suffixProduct *= nums[i];
//         }
        
//         return prefixProduct;
    }
}