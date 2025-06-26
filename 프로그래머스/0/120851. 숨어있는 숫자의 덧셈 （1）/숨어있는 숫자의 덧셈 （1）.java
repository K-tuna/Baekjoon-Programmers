import java.util.*;
class Solution {
    public int solution(String my_string) {
        int result = 0;
        char[] arr = my_string.toCharArray();
        for(char c : arr){
            if((c-'0')<10) result += c-'0';
        }
        return result;
    }
}