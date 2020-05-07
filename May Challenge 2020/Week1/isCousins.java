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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        TreeNode parentOfX = parent(root, x);
        TreeNode parentOfY = parent(root, y);
        
        if(parentOfX == null || parentOfY == null){
            return false;
        }
        else if(parentOfX.val == parentOfY.val) {    // same parent, hence siblings
            return false;
        }
        else {  // different parent
            //System.out.println(depth(root, x) + " " + depth(root, y));
            if(depth(root, x) == depth(root, y)) {  // same depth
                return true;
            }
        } 
        return false;
    }
    
    private int depth(TreeNode root, int z) {
        if(root == null) {
            return 0;
        }
        if(root.val == z) {
            return 1;
        }
        int temp =  Math.max(depth(root.left, z), depth(root.right, z));
        if(temp != 0) {
            return temp+1;
        }
        return 0;
    }
    
    private TreeNode parent(TreeNode root, int z) {
       if(root == null) {    // childless node
           return null;
       }
       if(root.left != null && root.left.val == z) {    // check left child
           return root;
       } 
       else if(root.right != null && root.right.val == z){  // check right child
           return root;
       } 
        
       TreeNode checkLeft = parent(root.left, z);
       TreeNode checkRight = parent(root.right, z);
       if(checkLeft != null) return checkLeft;
       return checkRight; 
    }
}
