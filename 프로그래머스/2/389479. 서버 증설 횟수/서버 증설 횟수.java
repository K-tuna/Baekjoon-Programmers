import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int plusCnt = 0; // 증설 횟수
        int[] servers = new int[players.length+k]; // 증설된 서버의 수 기록
        
        for(int i=0; i<players.length; i++) {
            if(players[i]/m > servers[i]){
                int plusN = players[i]/m - servers[i];
                plusCnt += plusN;
                for(int j=i; j<i+k; j++){
                    servers[j] += plusN;
                }
            }
        }
        return plusCnt;
    }
}