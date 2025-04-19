import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for(int n : score) {
            list.add(n);
        }
        list.sort((a,b) -> b-a);
        for(int i=m-1; i<score.length; i+=m){
            max += list.get(i)*m;
        }
        return max;
    }
}