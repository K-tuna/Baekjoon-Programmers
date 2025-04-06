import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int cnt = 0;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int n : d) {
            list.add(n);
        }
        list.sort((a,b) -> a-b);
        for(int n : list) {
            if(sum + n <= budget){
                sum += n;
                cnt ++;
            }else {
                return cnt;
            }
        }
        return cnt;
    }
}