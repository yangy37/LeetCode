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
    int result;
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        result = 1;
        List<Integer> list = new ArrayList<>();
        dfs(root,list,0,1);
        return result;
    }
    
    private void dfs(TreeNode root, List<Integer> list, int level, int value){
        if(root==null) return;
        if(list.size()==level){
            list.add(value);
        }else{
            result = Math.max(result,value-list.get(level)+1);
        }
        dfs(root.left, list, level+1, 2*value);
        dfs(root.right,list, level+1, 2*value+1);
    }
}