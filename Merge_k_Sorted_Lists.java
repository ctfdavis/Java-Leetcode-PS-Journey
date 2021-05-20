/*
Coded by DCUFO
Leetcode problem
23. Merge k Sorted Lists
Hard
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
Constraints:
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode toReturnNext = new ListNode(0);
        ListNode tail = toReturnNext;
        int ansLen = 0;
        int prevLen = 0;
        while (true) {
            int minimumVal = 99999;
            for (int i=0; i < lists.length; i++) {
                if (lists[i] != null && minimumVal > lists[i].val) minimumVal = lists[i].val;
            }
            for (int i=0; i < lists.length; i++) {
                if (lists[i] != null && minimumVal == lists[i].val) {
                    tail.next = lists[i];  
                    tail = tail.next;
                    ansLen++;
                    try {
                        lists[i] = lists[i].next;
                    } catch (Exception e) {
                        lists[i] = null;
                    }
                }
            }
            if (prevLen != ansLen) prevLen = ansLen;
            else break;
        }
        return toReturnNext.next;
    }
}