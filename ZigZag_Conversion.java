/*
Coded by DCUFO
Leetcode problem
6. ZigZag Conversion
Medium
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
*/

class Solution {
    public String convert(String s, int numRows) {
        int mod = (numRows-1) * 2;
        if (mod == 0) return s;
        List<StringBuilder> listSb = new ArrayList<>(numRows);
        int effectiveNumRows = numRows > s.length() ? s.length() : numRows;
        for (int i = 0; i < effectiveNumRows; i++) {
            listSb.add(new StringBuilder(""));
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (i%mod >= numRows) 
                listSb.get(2*numRows - i%mod - 2).append(s.charAt(i));
            else 
                listSb.get(i%mod).append(s.charAt(i));
        }
        for (int i = 0; i < effectiveNumRows; i++) {
            sb.append(listSb.get(i));
        }
        return sb.toString();
    }
}