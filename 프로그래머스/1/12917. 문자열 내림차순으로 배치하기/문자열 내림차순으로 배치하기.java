import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        for(char c : s.toCharArray()){
            list.add(c);
        }
        list.sort((a,b) -> b-a);
        for(char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}