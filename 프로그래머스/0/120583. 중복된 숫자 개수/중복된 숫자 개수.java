class Solution {
    public int solution(int[] array, int n) {
        int cnt = 0;
        for(int i : array){
            if(n==i) cnt++;
        }
        return cnt;
    }
}