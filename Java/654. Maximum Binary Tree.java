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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }

    public TreeNode dfs(int[] nums, int left, int right){
        if(left > right)
            return null;
        
        int max_num =Integer.MIN_VALUE;
        int index = -1;
        for(int i =left;i<=right;i++){
            if(nums[i] > max_num)
            {
                max_num = nums[i];
                index =i;
            }
        }
        
        TreeNode root = new TreeNode(max_num);
        root.left  = dfs(nums, left,index-1);
        root.right = dfs(nums, index+1, right);
        return root;
    }
}