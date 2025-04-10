import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<26; i++){
            map.put((char)('a'+i), -1);
        }
        for(int i=0; i<s.length(); i++){
            char key = s.charAt(i);
            int value = map.get(key);
            answer[i] = value==-1 ? value : i-value; 
            map.put(key,i);
        }
        return answer;
    }
}