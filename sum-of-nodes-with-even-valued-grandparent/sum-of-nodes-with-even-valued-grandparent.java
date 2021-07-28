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
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null) return 0; 
        
        int left = sumEvenGrandparent(root.left);
        int right = sumEvenGrandparent(root.right);
        
        int ans = 0;
        
        if(root.val % 2 == 0) {
            if(root.left != null && root.left.left != null) ans += root.left.left.val;
            if(root.left != null && root.left.right != null) ans += root.left.right.val;
            if(root.right != null && root.right.left != null) ans += root.right.left.val;
            if(root.right != null && root.right.right != null) ans += root.right.right.val;
        }
        return ans + left + right;
    }
}