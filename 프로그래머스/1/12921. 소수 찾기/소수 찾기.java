import java.util.*;
class Solution {
    public int solution(int n) {
        int cnt = 0;
        boolean[] isPrime = new boolean[n+1];
        for(int i=2; i<=Math.sqrt(n); i++){
            if(isPrime[i]==true) continue;
            
            for(int j=i+i; j<n+1; j+=i){
                isPrime[j]=true;
            }
        }
        for(int i=2; i<=n; i++){
            if(isPrime[i]==false) cnt++;
        }
        return cnt;
    }
}