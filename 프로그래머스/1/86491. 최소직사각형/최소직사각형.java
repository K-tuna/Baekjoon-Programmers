import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int w = 0, h = 0;
        for(int i=0; i<sizes.length; i++){
            w = Math.max(w, Math.max(sizes[i][0], sizes[i][1]));
            h = Math.max(h, Math.min(sizes[i][0], sizes[i][1]));
        }
        return w * h;
    }
}