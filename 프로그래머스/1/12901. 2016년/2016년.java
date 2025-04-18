class Solution {
    public String solution(int a, int b) {
        int[] months = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int cnt = b;
        for(int i=0; i<a; i++){
            cnt+=months[i];
        }
        return days[cnt%7];
    }
}