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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode newTreeNode = new TreeNode();
        if (t1 == null && t2 == null) { 
            return null;
        }
        else if (t1 == null) {
            newTreeNode = t2;
            return newTreeNode;
        }
        else if ( t2 == null) {
            newTreeNode = t1;
            return newTreeNode;
        }
        else {
            newTreeNode.val = t1.val + t2.val;
            newTreeNode.left = mergeTrees(t1.left, t2.left);
            newTreeNode.right = mergeTrees(t1.right, t2.right);
        }
        return newTreeNode;
    }
}