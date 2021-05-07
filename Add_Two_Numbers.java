/**
Coded by DCUFO
Leetcode problem
2. Add Two Numbers
Medium
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> intermediateList = new ArrayList<>();
        int carry = 0;
        while(true){
            int sum = l1.val + l2.val + carry;
            if (sum >= 10){
                intermediateList.add(sum - 10);
                carry = 1;
            }
            else{
                intermediateList.add(sum);
                carry = 0;
            }
            if(l1.next != null || l2.next != null || carry == 1) {
                l1 = l1.next == null ? new ListNode(0) : l1.next;
                l2 = l2.next == null ? new ListNode(0) : l2.next;
            }
            else {
                break;
            }

        }

        ListNode result = new ListNode(intermediateList.get(intermediateList.size()-1));
        for (int i = intermediateList.size() - 2; i >= 0; i--) {
            result= new ListNode(intermediateList.get(i), result);
        }
        return result;
    }
}