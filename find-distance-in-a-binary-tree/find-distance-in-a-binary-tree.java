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

/*
    @author: Nidhi
    
    Approach1: 
        Treat tree as a graph and do a bfs.
        Store parent node for every child node in a hashmap.
        for every node, explore its children and parent if not visited already
        
        Time Complexity: O(n)
        Space Complexity: O(n)
        
    
    Approach2:
        find LCA of nodes with value p and q
        find distance of LCA from node with value p and q respectively.
        distance = distanceFromLCA(p) + distanceFromLCA(q)
        
        Time Complexity: O(n)
    

*/

class Solution {
//     public int findDistance(TreeNode root, int p, int q) {
//         TreeNode lca = findLCA(root, p, q);
//         return distFromRoot(lca, p) + distFromRoot(lca, q);
//     }
    
//     private TreeNode findLCA(TreeNode root, int p, int q) {
//         if(root == null) return null;
        
//         if(root.val == p || root.val == q) return root;
        
//         TreeNode left = findLCA(root.left, p, q);
//         TreeNode right = findLCA(root.right, p, q);
        
//         if(left != null && right != null) return root;
        
//         if(left != null) return left;
//         return right;
        
//     }
    
//     private int distFromRoot(TreeNode root, int target) {
//         if(root == null) return -1;
        
//         if(root.val == target) return 0;
        
//         int left = distFromRoot(root.left, target);
//         int right = distFromRoot(root.right, target);
        
//         if(left == -1 && right == -1) return -1;
        
//         return left != -1 ? left+1 : right+1;
//     }
    
    TreeNode start = null;
    public int findDistance(TreeNode root, int p, int q) {
        HashMap<TreeNode, TreeNode> parent = new HashMap();
        parent.put(root, null);
        findParent(root, parent, p);
        
        Set<TreeNode> visited = new HashSet();
        
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(start);
        
        int dist = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            while(size-- > 0) {
                TreeNode node = queue.poll();
                visited.add(node);
                
                if(node.val == q) return dist;
        
                if(node.left != null && !visited.contains(node.left)) queue.offer(node.left);
                if(node.right != null && !visited.contains(node.right)) queue.offer(node.right);
                
                TreeNode nodeParent = parent.get(node);
                if(nodeParent != null && !visited.contains(nodeParent)) queue.offer(nodeParent);
            }            
            dist++;
        }
        return dist;   
    }
    
    private void findParent(TreeNode root, HashMap<TreeNode, TreeNode> parent, int p) {
        if(root == null) return;
        
        if(root.val == p) start = root;
        
        if(root.left != null) parent.put(root.left, root);
        if(root.right != null) parent.put(root.right, root);
        
        findParent(root.left, parent, p);
        findParent(root.right, parent, p);
    }
}