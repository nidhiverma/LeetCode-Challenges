/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair {
        int max, min, sum;
        boolean isBST;
        
        public Pair(int max, int min, int sum, boolean isBST) {
            this.max = max;
            this.min = min;
            this.sum = sum;
            this.isBST = isBST;
        }
    }
    
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }
    
    private Pair helper(TreeNode root) {
        if(root == null) return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        if(root.left == null && root.right == null) {
            maxSum = Math.max(maxSum, root.val);
            return new Pair(root.val, root.val, root.val, true);
        }
        
        if(root.left == null) {
            Pair right = helper(root.right);
            // System.out.println(root.val + " 0 " + right.sum);
            if(root.val < right.min && right.isBST) {
                maxSum = Math.max(root.val + right.sum, maxSum);
                return new Pair(right.max, root.val, right.sum + root.val, true);
            }
            return new Pair(0, 0, 0, false);
        }
        else if(root.right == null) {
            Pair left = helper(root.left);
            // System.out.println(root.val + " " + left.sum + " 0");
            if(root.val > left.max && left.isBST) {
                maxSum = Math.max(root.val + left.sum, maxSum);
                return new Pair(root.val, left.min, left.sum + root.val, true);
            }
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, false);
        }
        else {
            Pair left = helper(root.left);
            Pair right = helper(root.right);
            
            // System.out.println(root.val + " " + left.sum + " " + right.sum);
            
            boolean isBST = false;
            if(left.isBST && right.isBST) {
                if(root.val > left.max && root.val < right.min) {
                    int currSum = left.sum + root.val + right.sum;
                    // System.out.println(currSum);
                    maxSum = Math.max(maxSum, currSum);
                    return new Pair(right.max, left.min, currSum, true);
                }
                else {
                    return new Pair(0, 0, 0, false);
                }
            }
            return new Pair(0,0,0, false);
        }
    }
} 