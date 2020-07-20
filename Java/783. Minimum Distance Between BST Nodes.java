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
    int min = Integer.MAX_VALUE,prev = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return min;
    }
    
    private void helper(TreeNode root){
        if(root == null)return;
        helper(root.left);
        min = Math.min(min,Math.abs( prev - root.val ));
        prev = root.val;
        helper(root.right);
    }
}