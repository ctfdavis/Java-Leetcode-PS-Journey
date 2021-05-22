/*
Coded by DCUFO
Leetcode problem
25. Reverse Nodes in k-Group
Hard
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
Constraints:
The number of nodes in the list is in the range sz.
1 <= sz <= 5000
0 <= Node.val <= 1000
1 <= k <= sz
*/
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1) return head;
        ListNode toReturn = new ListNode(0); 
        ListNode helperList = toReturn;
        while (true) {
            for (int i = 0; i < k; i++) {
                if (i > 0) helperList.next = new ListNode(helperList.val, helperList.next);
                helperList.val = head.val;
                head = head.next;
            }
            for (int i = 0; i < k-1; i++) {
                helperList = helperList.next;
            }
            helperList.next = head;
            helperList = helperList.next;
            try {
                ListNode remaining = head;
                for (int i = 0; i < k-1; i++) {
                    remaining = remaining.next;
                    if (remaining.val > -1) continue;
                }
            } catch (Exception e) {
                break;
            }
        }
        return toReturn;
    }
}