import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        char[] arr = my_string.toCharArray();
        List<Integer> list = new ArrayList<>();
        for(char c : arr) {
            if(Character.isDigit(c)) list.add(c-'0');
        }
        list.sort((a,b)->a-b);
        return list.stream().mapToInt(i->i).toArray();
    }
}