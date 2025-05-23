class Solution {
    public int solution(int[] dot) {
        int result = 0;
        int x = dot[0], y = dot[1];
        if     (x>0&&y>0) result = 1;
        else if(x<0&&y>0) result = 2;
        else if(x<0&&y<0) result = 3;
        else if(x>0&&y<0) result = 4;
        return result;
    }
}