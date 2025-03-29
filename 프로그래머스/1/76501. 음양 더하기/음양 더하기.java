class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int num = 0;
        for(int i=0; i<absolutes.length; i++){
            num += signs[i] ? absolutes[i] : -absolutes[i];
        }
        return num;
    }
}