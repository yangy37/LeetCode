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
    public int dfs(TreeNode root)
{
    if(root==null)
    {
        return 0;
    }
    int l=0,r=0;
    if(root.left!=null)
    {
        l=dfs(root.left);
        if(l==0)
        {
            root.left=null;
        }
    }
    if(root.right!=null)
    {
        r=dfs(root.right);
        if(r==0)
        {
            root.right=null;
        }
    }
    return root.val+l+r;
}
public TreeNode pruneTree(TreeNode root) {
    int val=dfs(root);
    if(val==0)
    {
        root=null;
    }
    return root;
}
}