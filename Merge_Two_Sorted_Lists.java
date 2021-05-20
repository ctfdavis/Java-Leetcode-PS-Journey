/*
Coded by DCUFO
Leetcode problem
21. Merge Two Sorted Lists
Easy
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        List<Integer> toMerge = new ArrayList<>();
        ListNode toReturn = new ListNode().next;
        ListNode remaining = null;
        
        /* handling any empty listnode(s)*/
        Integer currL1Head = null;
        Integer currL2Head = null;
        try {
            currL1Head = l1.val;
            currL2Head = l2.val;
        } catch (Exception e) {
            if (currL1Head == null) return l2;
            else return l1;
        }
        
        while (true) {
            if (currL1Head == currL2Head) {
                toMerge.add(new Integer(currL1Head));
                toMerge.add(new Integer(currL2Head));
                l1 = l1.next;
                l2 = l2.next;
                currL1Head = null;
                currL2Head = null;
                try {
                    currL1Head = l1.val;
                } catch (Exception e) {
                    try {
                        currL2Head = l2.val;
                        remaining = l2;
                        break;
                    } catch (Exception e2) {
                        break;
                    }
                }
                try {
                    currL2Head = l2.val;
                } catch (Exception e) {
                    remaining = l1;
                    break;
                }
            } else if (currL1Head < currL2Head) {
                toMerge.add(new Integer(currL1Head));
                l1 = l1.next;
                 try {
                    currL1Head = l1.val;
                 } catch (Exception e) {
                     remaining = l2;
                     break;
                 }
            } else {
                toMerge.add(new Integer(currL2Head));
                l2 = l2.next;
                 try {
                    currL2Head = l2.val;
                 } catch (Exception e) {
                     remaining = l1;
                     break;
                 }
            }
        }
        
        if (remaining != null) toReturn = remaining;
        
        for (int i = toMerge.size() - 1 ; i >= 0; i--) {
            toReturn = new ListNode(toMerge.get(i), toReturn);
        }
        
        return toReturn;
    }
}