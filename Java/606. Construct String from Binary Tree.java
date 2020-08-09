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
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = t;
        TreeNode lastVisitedNode = null;
        StringBuilder sb = new StringBuilder();
        
        //Do a pre-order traversal while preparing string in the needed format
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                sb.append("(" + curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            if(curr.right != null && curr.right != lastVisitedNode){
                //Since they want an extra "()" whenever left ndoe is empty but right is not.
                if(curr.left == null){
                    sb.append("()");
                }
                curr = curr.right;
                continue;
            }
            sb.append(")");
            
            lastVisitedNode = stack.pop();
            curr = null;
        }
        //Since our program puts start and end parentesis. So Removing those.
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
}