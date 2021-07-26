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
        int count, sum;
        public Pair(int count, int sum) {
            this.count = count;
            this.sum = sum;
        }
    }
    
    double average = 0.0;
    
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return average;
    }
    
    private Pair helper(TreeNode root) {
        if(root == null) return new Pair(0, 0);
        
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        int sum = left.sum + right.sum + root.val;
        int count = left.count + right.count + 1;
        
        average = Math.max(average, (double)sum/count);
        return new Pair(count, sum);
    }
        
}