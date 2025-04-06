import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        List<Integer> wList = new ArrayList<>();
        List<Integer> hList = new ArrayList<>();
        for(int i=0; i<sizes.length; i++){
            wList.add(Math.max(sizes[i][0],sizes[i][1]));
            hList.add(Math.min(sizes[i][0],sizes[i][1]));
        }
        wList.sort((a,b) -> b-a);
        hList.sort((a,b) -> b-a);
        return wList.get(0) * hList.get(0);
    }
}