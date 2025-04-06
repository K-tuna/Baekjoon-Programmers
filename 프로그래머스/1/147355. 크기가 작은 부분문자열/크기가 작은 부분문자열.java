class Solution {
    public int solution(String t, String p) {
        int cnt = 0;
        int lenP = p.length();
        long numP = Long.parseLong(p);
        for(int i=0; i <= t.length() - lenP; i++){
            long numT = Long.parseLong(t.substring(i, i+lenP));
            if(numT <= numP) cnt ++;
        }
        return cnt;
    }
}