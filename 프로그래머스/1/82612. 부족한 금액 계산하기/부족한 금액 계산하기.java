class Solution {
    public long solution(int price, int money, int count) {
        long result = (long)count*((long)count+1)/2 * (long)price - (long)money;
        return result > 0 ? result : 0;
    }
}