import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int cnt = 1;
        int now = section[0];
        for(int i=1; i<section.length; i++){
            if(now + m -1 < section[i]){
                cnt++;
                now = section[i];
            }
        }
        return cnt;
    }
}