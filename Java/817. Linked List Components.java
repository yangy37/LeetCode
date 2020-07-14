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
    public int numComponents(ListNode head, int[] G) {

    Set<Integer> set = new HashSet<>();

    for(int i = 0; i < G.length; i++) {
        set.add(G[i]);
    }
    int connectcomp = 0;
    ListNode curr = head;
    while (curr!=null) {
        if(set.contains(curr.val)) {
            connectcomp++;
            while (curr!=null && set.contains(curr.val)) {
                curr = curr.next;
            }
        } else {
            curr = curr.next;
        }
    }
    return connectcomp;
}
}