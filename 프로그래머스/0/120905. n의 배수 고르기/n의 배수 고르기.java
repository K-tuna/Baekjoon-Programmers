import java.util.*;
class Solution {
    public List<Integer> solution(int n, int[] numlist) {
        List<Integer> list = new ArrayList<>();
        for(int num : numlist){
            if(num%n==0) list.add(num);
        }
        return list;
    }
}