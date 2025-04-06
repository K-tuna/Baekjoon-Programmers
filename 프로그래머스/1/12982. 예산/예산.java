import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        List<Integer> list = new ArrayList<>();
        for(int n : d) {
            list.add(n);
        }
        list.sort((a,b) -> a-b);
        int cnt = 0;
        int sum = 0;
        for(int n : list) {
            if(sum + n > budget) break;
            sum += n;
            cnt ++;
        }
        return cnt;
    }
}