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
   
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        flatten(left);
        flatten(right);
        
        root.left = null;
        
        // get last node flattened left subtree
        TreeNode tail = getTail(left);
        if(tail != null) {
            tail.right = right;
            root.right = left;
        }
        else {
            root.right = right;
        }
    }
    
    private TreeNode getTail(TreeNode root) {
        if(root == null) return null;
        
        TreeNode tail = root;
        while(tail.right != null) {
            tail = tail.right;
        }
        return tail;
    }
    
}