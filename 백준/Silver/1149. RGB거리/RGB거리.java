import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp = new int[N+1][3];
		int min = Integer.MAX_VALUE;
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dp[i][0] = r + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = g + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = b + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		for(int i : dp[N]) {
			min = Math.min(i, min);
		}
		System.out.println(min);
	}
}