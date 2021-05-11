/**
Coded by DCUFO
Leetcode problem
10. Regular Expression Matching
Hard
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where: 

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
 */
class Solution {

    private boolean reached = false;

    public List<String> pToList(String pattern) {
        List<String> patternList = new ArrayList<>();
        int lastTempIdx = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*') {
                if (i - lastTempIdx == 1) {
                    patternList.add(pattern.substring(lastTempIdx, i + 1));
                } else {
                    patternList.add(pattern.substring(lastTempIdx, i - 1));
                    patternList.add(pattern.substring(i - 1, i + 1));
                }
                lastTempIdx = i + 1;
            } else if (pattern.charAt(i) == '.') {
                if (i < pattern.length() - 1) {
                    if (pattern.charAt(i + 1) == '*') {
                        if (i - lastTempIdx == 0) {
                            patternList.add(pattern.substring(lastTempIdx, i + 2));
                        } else {
                            patternList.add(pattern.substring(lastTempIdx, i));
                            patternList.add(pattern.substring(i, i + 2));
                        }
                        lastTempIdx = i + 2;
                        i++;
                        continue;
                    }
                }
                if (i - lastTempIdx == 0) {
                    patternList.add(pattern.substring(lastTempIdx, i + 1));
                } else {
                    patternList.add(pattern.substring(lastTempIdx, i));
                    patternList.add(pattern.substring(i, i + 1));
                }
                lastTempIdx = i + 1;
            }
        }
        if (lastTempIdx < pattern.length()) {
            patternList.add(pattern.substring(lastTempIdx));
        }
        System.out.println(patternList);
        return patternList;
    }
    
    public List<String> compressPList(List<String> pList) {
        for (int i = 0; i < pList.size()-1; i++) {
            if (pList.get(i).equals(pList.get(i+1)) && pList.get(i).contains("*")) {
                pList.remove(i);
                i--;
                continue;
            }
        }
        return pList;
    }

    public void recursiveTest(List<String> pList, String str) {
        for (int i = 0; i < pList.size(); i++) {

            if (pList.get(i).contains("*")) {
                boolean notdot = false;
                for (int j = 0; j <= str.length(); j++) {
                    String tempPattern = Character.toString(pList.get(i).charAt(0)).repeat(j);
                    if (tempPattern.contains(".")) {
//                            System.out.println(pList.subList(i + 1, pList.size()));
                        recursiveTest(pList.subList(i + 1, pList.size()), str.substring(j));
                    } else {
                        if (str.startsWith(tempPattern)) {
                            // System.out.println(j);
                                // System.out.println(pList.subList(i + 1, pList.size()));
                            recursiveTest(pList.subList(i + 1, pList.size()), str.substring(j));
                        } else {
                            if (notdot) {
                                break;
                            }
                            notdot = true;
                            continue;
                        }
                    }
                }
                break;
            } else {
                if (str.length() > 0) {
                    if (str.startsWith(pList.get(i)) || pList.get(i).contains(".")) {
                        // System.out.println(pList.subList(i + 1, pList.size()));
//                        System.out.println(str.substring(1));
                        recursiveTest(pList.subList(i + 1, pList.size()), str.substring(pList.get(i).length()));
                    } else {
                        break;
                    }
                    break;
                } else {
                    break;
                }
            }
        }
        if (pList.isEmpty() && str.length() == 0) {
            // System.out.println("reached");
            reached = true;
        }
    }

    public boolean isMatch(String s, String p) {
        List<String> patternList = compressPList(pToList(p));
        recursiveTest(patternList, s);
        return reached;
    }
}