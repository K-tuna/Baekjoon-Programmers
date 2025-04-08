import java.util.*;
class Solution {
    static int N,R=3,C=0;
    static int[] a, b=new int[R];
    public int solution(int[] number) {
        N = number.length;
        a = number;
        comb(0,0);
        return C;
    }
    static public void comb(int cnt, int start){
        if(cnt==R){
            if(b[0]+b[1]+b[2]==0) C++;
            return;
        }
        for(int i=start; i<N; i++){
            b[cnt] = a[i];
            comb(cnt+1, i+1);
        }
    }
}