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
    int maxDepth = Integer.MIN_VALUE;
    
    public List<List<String>> printTree(TreeNode root) {
        dfs(root, 1);
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<String>> res = new ArrayList<>();
        int currLevel = 1;
        
        while (!q.isEmpty() && currLevel <= maxDepth) {
            String[] arr = new String[(int) (Math.pow(2, maxDepth) - 1)];
            Arrays.fill(arr, "");
            int size = q.size();
            int start = (int) Math.pow(2, maxDepth - currLevel) - 1;
            int step = (int) Math.pow(2, maxDepth - currLevel + 1);
            while (size > 0) {
                TreeNode node = q.poll();
                
                if (node != null) {
                    arr[start] = Integer.toString(node.val);
                    q.add(node.left);
                    q.add(node.right);
                } else {
                    q.add(null);
                    q.add(null);
                }
                start += step;
                size--;
            }
            res.add(Arrays.asList(arr));
            currLevel++;
        }
        return res;
    }
    
    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        maxDepth = Math.max(depth, maxDepth);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}