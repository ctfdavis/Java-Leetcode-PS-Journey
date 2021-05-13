/*
Coded by DCUFO
Leetcode problem
13. Roman to Integer
Easy
Given a roman numeral, convert it to an integer.
Constraints:
1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
*/
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        if (s.contains("CM")) {
            sum += 900;
            s = s.substring(0, s.indexOf("CM")) + s.substring(s.indexOf("CM") + 2);
        } else if (s.contains("CD")) {
            sum += 400;
            s = s.substring(0, s.indexOf("CD")) + s.substring(s.indexOf("CD") + 2);
        }
        if (s.contains("XC")) {
            sum += 90;
            s = s.substring(0, s.indexOf("XC")) + s.substring(s.indexOf("XC") + 2);
        } else if (s.contains("XL")) {
            sum += 40;
            s = s.substring(0, s.indexOf("XL")) + s.substring(s.indexOf("XL") + 2);
        }
        if (s.contains("IX")) {
            sum += 9;
            s = s.substring(0, s.indexOf("IX")) + s.substring(s.indexOf("IX") + 2);
        } else if (s.contains("IV")) {
            sum += 4;
            s = s.substring(0, s.indexOf("IV")) + s.substring(s.indexOf("IV") + 2);
        }
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    sum += 1000;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'I':
                    sum += 1;
            }
        }
        return sum;
    }
}