import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        for(int citation: citations) list.add(citation);
        Collections.sort(list, (o1,o2)-> o2-o1);
        System.out.print(list);
        for(int i=0; i<list.size(); i++){
            int H_index=Math.min(list.get(i),i+1);
            if(ans<H_index)
                ans=H_index;
        }
        return ans;
    }
}