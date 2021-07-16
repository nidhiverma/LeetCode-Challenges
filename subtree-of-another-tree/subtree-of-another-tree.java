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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        return check(root, subRoot);
    }
    
    private boolean check(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        
        if(root.val == subRoot.val && isMatching(root, subRoot)) return true;
        return check(root.left, subRoot) || check(root.right, subRoot);
    }
    
    private boolean isMatching(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null ^ subRoot == null || root.val != subRoot.val) return false;
        
        return isMatching(root.left, subRoot.left) && isMatching(root.right, subRoot.right);
    }
}