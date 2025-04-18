class Solution {
    public int solution(int number, int limit, int power) {
        int total = 0;
        for(int n=1; n<=number; n++){
            int cnt = 0;
            for(int i=1; i*i <= n; i++){
                if(i*i == n) cnt++;
                else if(n%i==0) cnt+=2;
                if(cnt>limit) {
                    cnt=power;
                    break;
                }
            }
            total += cnt;
        }
        return total;
    }
}