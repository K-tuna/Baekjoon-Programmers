import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int max = 0;
        Arrays.sort(score);
        for(int i=score.length; i>=m; i-=m){
            max += score[i-m]*m;
        }
        return max;
    }
}