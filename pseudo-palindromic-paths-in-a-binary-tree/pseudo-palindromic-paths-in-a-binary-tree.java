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
    int pathCount = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        helper(root, new int[10]);
        return pathCount;
    }
    
    private void helper(TreeNode root, int[] count) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            count[root.val]++;
            if(validPath(count)) pathCount++;
            count[root.val]--;
            return;
        }
        count[root.val]++;
        
        helper(root.left, count);
        helper(root.right, count);
        
        count[root.val]--;
    }
    
    private boolean validPath(int[] count) {
        boolean oddFound = false;
        
        for(int c : count) {
            if(c % 2 != 0) {
                if(oddFound) return false;
                oddFound = true;
            }
        }
        return true;
    }
}