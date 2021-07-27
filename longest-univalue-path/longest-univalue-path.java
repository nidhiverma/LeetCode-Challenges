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
    int maxPathLength = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return maxPathLength;
    }
    
    private int helper(TreeNode root) {
        if(root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int leftLen = 0;
        int rightLen = 0;
        
        if(root.left != null && root.left.val == root.val) {
            leftLen += left + 1;
        }
        
        if(root.right != null && root.right.val == root.val) {
            rightLen += right + 1;
        }
        
        maxPathLength = Math.max(maxPathLength, leftLen + rightLen);
        return Math.max(leftLen, rightLen);
    }
}