/*
Coded by DCUFO
Leetcode problem
24. Swap Nodes in Pairs
Medium
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
Constraints:
The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
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
    private boolean hasNextHead(ListNode head) {
        try {
            int dummy = head.next.val;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private ListNode nextNextHead(ListNode head) {
        try {
            ListNode nextNextHead = head.next.next;
            return nextNextHead;
        } catch (Exception e) {
            return null;
        }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode toReturn = head;
        while (hasNextHead(head)) {
            int prevVal = head.val;
            head.val = head.next.val;
            head.next.val = prevVal;
            if (nextNextHead(head) == null) break;
            else head = nextNextHead(head);
        }
        return toReturn;
    }
}