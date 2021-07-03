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
    Integer maxPath = null;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxPath == null ? 0: maxPath;
    }
    
    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
       
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        
        int currSum = root.val + left + right;
        
        if(maxPath == null || maxPath < currSum) maxPath = currSum;
       
        return Math.max(left, right) + root.val;
    }
}