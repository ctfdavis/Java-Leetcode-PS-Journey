/*
Coded by DCUFO
Leetcode problem
17. Letter Combinations of a Phone Number
Medium
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/
class Solution {
    private String[] mapDigitToLetters(String digit) {
        switch (digit) {
            case "2":
                return new String[]{"a","b","c"};
            case "3":
                return new String[]{"d","e","f"};
            case "4":
                return new String[]{"g","h","i"};
            case "5":
                return new String[]{"j","k","l"};
            case "6":
                return new String[]{"m","n","o"};
            case "7":
                return new String[]{"p","q","r","s"};
            case "8":
                return new String[]{"t","u","v"};
            case "9":
                return new String[]{"w","x","y","z"};
        }
        return new String[0];
    }
    private void recursiveLoop(String digits, List<String> resultList, List<String> currList){
        String headDigit = Character.toString(digits.charAt(0));
        String[] digitList = mapDigitToLetters(headDigit);
        List<String> nextList = new ArrayList<>();
        if (currList == null)
            nextList = new ArrayList<>(Arrays.asList(digitList));
        else {
            for (int i = 0; i < currList.size(); i++) {
                for (int j = 0; j < digitList.length; j++) {
                    nextList.add(currList.get(i) + digitList[j]);
                }
            }
        }
        if (digits.length() == 1) {
            for (String output : nextList) {
                resultList.add(output);
            }
        } else {
            recursiveLoop(digits.substring(1), resultList, nextList);
        }
    }
    public List<String> letterCombinations(String digits){
        List<String> resultList = new ArrayList<>();
        if (digits.length() > 0)
            recursiveLoop(digits, resultList, null);
        return resultList;
    }
}