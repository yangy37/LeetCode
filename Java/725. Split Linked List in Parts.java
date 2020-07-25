/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] arr = new ListNode[k];
        ListNode cur = root;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        
        int length = 0;
        int extra = 0;
        if(k<=count){
            if(count%k != 0){
                extra = count%k;
            }
            length = count/k;
        }
        
        ListNode split = root;
        cur = root;
        for(int i=0; i<k; i++){
            if(i>=count){
                arr[i] = null;
                continue;
            }
            for(int j=0; j<length-1; j++){
                cur = cur.next;
            }
            if(extra != 0){
                cur = cur.next;
                extra--;
            }
            
            split = cur.next;
            cur.next = null;
            arr[i] = root;
            root = split;
            cur = split;
            
        }
        return arr;
    }
}