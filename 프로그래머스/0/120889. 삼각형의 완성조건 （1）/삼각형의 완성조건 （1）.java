class Solution {
    public int solution(int[] sides) {
        int max = Math.max(sides[0],Math.max(sides[1],sides[2]));
        return max < sides[0]+sides[1]+sides[2]-max ? 1:2;
    }
}