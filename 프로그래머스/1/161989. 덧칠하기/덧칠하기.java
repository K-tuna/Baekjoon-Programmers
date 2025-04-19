import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int result = 0;
        int idx = 0;
        while(idx<section.length){
            int last = section[idx] + m - 1;
            result++;
            while(idx<section.length && section[idx] <= last){
                idx++;
            }
        }
        return result;
    }
}