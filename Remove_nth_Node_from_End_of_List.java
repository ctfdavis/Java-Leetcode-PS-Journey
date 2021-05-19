/*
Coded by DCUFO
Leetcode problem
19. Remove Nth Node From End of List
Medium
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Follow up: Could you do this in one pass?

Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        /* local variables to work with */
        boolean nextTurn = false;
        ListNode firstHead = new ListNode(head.val, head.next);
        ListNode secondHead = new ListNode(head.val, head.next);
        ListNode toReturn = new ListNode();
        
        
        /* for calculating the length of the given node list */
        ListNode next = head;
        int listLen = 0;
        while (true) {
            try {
                next = next.next;
                listLen++;
            } catch(Exception e) {
                break;
            }
        }
                
        /* m from the beginning of the list (index 0) is index of node to remove */
        int m = listLen - n ;       
        
        /* if there's only 1 element in the node list, return an empty node list */
        if (listLen == 1) return toReturn.next;
        
        /* if remove first element, just return the remaining list from the head */
        if (m == 0) return head.next;
        
        /* two for loops to exclude the element to be removed */
        for (int i = 0 ; i <= m; i++) {
            firstHead = firstHead.next;
        }
        
        for (int i = 0; i < m ; i++) {
            if (i == m - 1) secondHead.next = firstHead;
            else secondHead = secondHead.next;
        }
        
        /* if remove the second element from the beginning, return the result right away */
        if (m == 1) {
            return secondHead;
        }
        
        /* otherwise, create a backwards loop to rebuild the entire node list */
        while (m > 1) {
            m--;
            if (m == 1) {
                break;
            }
            if (!nextTurn) {
                nextTurn = true;
                firstHead = new ListNode(head.val, head.next);
                for (int i = 0; i < m ; i++) {
                    if (i == m - 1) firstHead.next = new ListNode(secondHead.val, secondHead.next);
                    else firstHead = firstHead.next;
                }
            } else {
                nextTurn = false;
                secondHead = new ListNode(head.val, head.next);
                for (int i = 0; i < m ; i++) {
                    if (i == m - 1) secondHead.next = new ListNode(firstHead.val, firstHead.next);
                    else secondHead = secondHead.next;
                }
            }
        }
    
    toReturn = new ListNode(head.val, head.next);
    toReturn.next = nextTurn ? firstHead : secondHead;
        
    return toReturn;
    }
}