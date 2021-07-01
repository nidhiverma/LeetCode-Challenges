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
    List<TreeNode> res = new ArrayList();
    Set<Integer> nodesToBeDeleted = new HashSet();
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int node: to_delete) {
            nodesToBeDeleted.add(node);
        }    
        helper(root, null);
        return res;
    }
    
    private void helper(TreeNode root, TreeNode parent) {
        if(root == null) return;
        
        // if current root is not to be deleted, add it to result
        if(!nodesToBeDeleted.contains(root.val)) {
            if(parent == null || nodesToBeDeleted.contains(parent.val)) {
                res.add(root);
            }
        }
        
        // delete nodes in left subtree
        helper(root.left, root);
        // delete nodes in right subtree
        helper(root.right, root);
        
        // if root.left is to be deleted, set root.left as null
        if(root.left != null && nodesToBeDeleted.contains(root.left.val)) {
            root.left = null;
        }
        
        // if root.right is to be deleted, set root.right as null
        if(root.right != null && nodesToBeDeleted.contains(root.right.val)) {
            root.right = null;
        }
    }
}