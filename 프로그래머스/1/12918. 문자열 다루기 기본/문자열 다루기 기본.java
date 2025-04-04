import java.util.*;
class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length()==4 | s.length()==6) {
            char[] chars = s.toCharArray();
            for(char c : chars){
                if(!Character.isDigit(c)) return false; 
            }
            return true;
        } else return false;
    }
}