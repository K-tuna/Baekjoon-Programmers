class Solution {
    public int solution(int left, int right) {
        int result = 0;
        for(int i=left; i<=right; i++){
            result += i%Math.sqrt(i)==0 ? -i : i;
        }
        return result;
    }
}