/*
Coded by DCUFO
Leetcode problem
20. Valid Parentheses
Easy
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/
class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        Map<Character, Character> openClose  = new HashMap<>() {{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        for (int z = 0; z < s.length(); z++) {
            if (openClose.containsValue(s.charAt(z))) deque.addFirst(s.charAt(z));
            else {
                try {
                    if (deque.removeFirst() != openClose.get(s.charAt(z))) return false;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return deque.isEmpty() ? true : false;
    }
}