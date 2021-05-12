/*
Coded by DCUFO
Leetcode problem
12. Integer to Roman
Medium
Given an integer, convert it to a roman numeral.
1 <= num <= 3999
*/
class Solution {
    private String digitToRoman(int digit, int place) {
        String smallUnit = "";
        String mediumUnit = "";
        String bigUnit = "";
        String romanValue = "";
        /* given 1 <= num <= 3999, only 4 cases here */
        switch (place) {
            case 1:
                smallUnit = "I";
                mediumUnit = "V";
                bigUnit = "X";
                break;
            case 2:
                smallUnit = "X";
                mediumUnit = "L";
                bigUnit = "C";
                break;
            case 3:
                smallUnit = "C";
                mediumUnit = "D";
                bigUnit = "M";
                break;
            case 4:
                smallUnit = "M";
        }
        if (digit < 4) romanValue = smallUnit.repeat(digit);
        else if (digit == 4) romanValue = smallUnit + mediumUnit;
        else if (digit < 9) romanValue = mediumUnit + smallUnit.repeat(digit-5);
        else romanValue = smallUnit + bigUnit;
        return romanValue;
    }
    public String intToRoman(int num) {
        String roman = "";
        /* default the digit to be 1 */
        int digit = 1;
        /* check how many digits is the number */
        while (true) {
            if (num / Math.pow(10, digit) > 0) digit++;
            else break;
        }
        
        /* initialize the "previous remainder" prior the loop*/
        int prev = 0;
        
        /* loop through each digit of the given number */
        for (int i = 1; i <= digit; i++) {
            /* find each digit in the number using modulus with the below algorithm*/
            int x = (int) ((num % Math.pow(10, i) - prev) / Math.pow(10, i-1));
            /* set up previous remainder for the next loop */
            prev = x;
            /* add the converted roman digit to the start of the final value string */
            roman = digitToRoman(x, i) + roman;
        }
        return roman;
    }
}