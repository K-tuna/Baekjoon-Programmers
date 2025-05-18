class Solution {
    public int solution(int[] array, int height) {
        int cnt = 0;
        for(int h : array){
            if(h>height) cnt++;
        }
        return cnt;
    }
}