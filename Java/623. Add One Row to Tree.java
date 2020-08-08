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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1) return new TreeNode(v, root, null);
        addRow(root, v, d-1);
        return root;
    }
    private void addRow(TreeNode n, int v, int d) {
        if(n==null) return;
        if(d==1) {
            n.left = new TreeNode(v, n.left, null);
            n.right = new TreeNode(v, null, n.right);
        } else {
            addRow(n.left, v, d-1);
            addRow(n.right, v, d-1);
        }
    }
}