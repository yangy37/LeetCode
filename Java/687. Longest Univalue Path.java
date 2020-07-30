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
    int path = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        
        // get out quick
        if (root == null) 
            return 0;
        
        // recurse through the tree
        treeTraverse(root, 0);
        return path;
    }
    
    // method to traverse the tree using recursion, pre-order dfs
    private int treeTraverse (TreeNode root, int previousVal) {
        if (root == null)
            return 0;
        
        // traverse left, then right
        int left = treeTraverse(root.left, root.val);
        int right = treeTraverse(root.right, root.val);
        
        // calculate the longest path
        path = Math.max(left + right, path);

        //return
        if (root.val == previousVal) 
            return Math.max(left, right) + 1;
        
        return 0;
    }
}