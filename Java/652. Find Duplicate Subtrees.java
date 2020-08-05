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
    Map<Integer, Integer> count;
    Map<String, Integer> map;
    List<TreeNode> res;
    int globalId;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        map = new HashMap<>();
        res = new ArrayList<>();
        globalId = 1;
        postorderTraverse(root);
        return res;
    }
    public int postorderTraverse(TreeNode node) {
        if(node == null) return 0;
        String serial = node.val + "," + postorderTraverse(node.left) + "," + postorderTraverse(node.right);
        int uniqueId = map.computeIfAbsent(serial, x->globalId++); //get/create a uniqueId; computeIfAbsent only compute if key doesn't exist
        count.put(uniqueId, count.getOrDefault(uniqueId, 0) + 1);
        if(count.get(uniqueId) == 2){
            res.add(node);
        }
        return uniqueId;
    }
}