import java.util.*;
class Solution {
    public List<Integer> solution(int n) {
        List<Integer> list = new ArrayList<>();
        while(true){
            list.add(n);
            if(n==1) break;
            n = n%2==0 ? n/2 : 3*n+1;
        }
        return list;
    }
}