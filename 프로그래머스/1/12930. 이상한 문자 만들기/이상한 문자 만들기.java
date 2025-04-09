import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i=0; i<s.length(); i++){
            String str = s.substring(i,i+1);
            if(str.equals(" ")) {
                sb.append(str);
                idx=0;
            }
            else {
                if(idx%2==0) {
                    sb.append(str.toUpperCase());
                }else  {
                    sb.append(str.toLowerCase());
                }     
                idx++;
            }
            
        }
        return sb.toString();
    }
}