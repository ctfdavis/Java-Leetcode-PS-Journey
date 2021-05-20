/*
Coded by DCUFO
Leetcode problem
22. Generate Parentheses
Medium
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Constraints:
1 <= n <= 8
*/
class Solution {
    private List<String> toReturn = new ArrayList<>(); 
    private void generator(int numPair, int numLeft, int numRight, String str) {
        if (numPair*2 > str.length()) {
            if (numLeft > numRight)
                generator(numPair, numLeft, numRight+1, str+")");
            if (numLeft < numPair)
                generator(numPair, numLeft+1, numRight, str+"(");
        } else {
            toReturn.add(str);
        }
    }
    public List<String> generateParenthesis(int n) {
        String left = "(";
        String right = ")";
        generator(n, 0, 0, "");
        return toReturn;
    }
}