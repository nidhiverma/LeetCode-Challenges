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
    protected TreeNode firstElement = null;
    protected TreeNode secondElement = null;
    protected TreeNode prevElement = null;
    
    public void recoverTree(TreeNode root) {
        traverseTree(root);
        
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    private void traverseTree(TreeNode root) {
        if(root == null) return;
        
        traverseTree(root.left);
        
        if(firstElement == null && prevElement != null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }
        
        if(firstElement != null && prevElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        prevElement = root;
        traverseTree(root.right);
    }
}