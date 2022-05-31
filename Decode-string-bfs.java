import java.util.*;

class Solution {
    // BFS Solution
    // Time complexity is O(output string) in terms of output
    // Time complexity is O(n) length of string + max(k) [max number] * m[m is the currStr length]
    // Space complexity is O(m + n) where m is the str stack and n is num stack.
    public String decodeString(String s) {
        //Egde case
        if(s == null || s.length() == 0) return "";
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum*10 + c - '0';
            } else if(c == '['){
                numSt.push(currNum);
                strSt.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            } else if (c == ']'){
                int num = numSt.pop();
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j< num;j++){
                    temp.append(currStr);
                }
                // Add parent first
                StringBuilder parent = strSt.pop();
                currStr = parent.append(temp);
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}