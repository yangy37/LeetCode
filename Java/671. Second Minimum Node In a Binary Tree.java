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
    public int findSecondMinimumValue(TreeNode root) {
        Integer x = distinct(root.left,root.val);
        Integer y = distinct(root.right,root.val);
        Integer solution = min(x,y);
        return solution==null?-1:solution;
    }
    
    public Integer distinct(TreeNode node, int val){
        if(node==null)
            return null;
        if(val!=node.val)
            return node.val;
        return min(distinct(node.left,val),distinct(node.right,val));
    }
    public Integer min(Integer x, Integer y){
        if(x==null&&y==null)
            return null;
        if(x==null)
            return y;
        if(y==null)
            return x;
        return Math.min(x,y);
    }
    
}