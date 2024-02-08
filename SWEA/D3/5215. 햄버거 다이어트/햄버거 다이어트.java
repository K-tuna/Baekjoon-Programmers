import java.io.*;
import java.util.*;

public class Solution {
	static int N,L;
	static int[] score;
	static int[] cal;
	static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int count = st.countTokens() - 2;
			
			ans = 0;
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			score = new int[N];
			cal = new int[N];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int s = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				score[i] = s;
				cal[i] = c;
			}
			dfs(0,0,0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	public static void dfs(int i, int total_score, int total_cal) {
		if (total_cal > L) {
			return;
		}
		if (i == N) {
			if (total_score > ans) {
				ans = total_score;
			}
			return;
		}
		dfs(i+1, total_score + score[i], total_cal + cal[i]);
		dfs(i+1, total_score, total_cal);
	}
}