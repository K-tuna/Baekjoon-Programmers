import java.util.*;
class Solution {
    public long solution(long n) {
        ArrayList<Integer> list = new ArrayList<>();
        String number = String.valueOf(n);
        for(int i=0; i<number.length(); i++){
            list.add(number.charAt(i)-'0');
        }
        list.sort((a,b) ->  b-a);
        String str = "";
        for(int num : list){
            str = str+num;
        }
        return Long.parseLong(str);
    }
}