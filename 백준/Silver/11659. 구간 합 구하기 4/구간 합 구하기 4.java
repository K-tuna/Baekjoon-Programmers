import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] arr;
	static int[] dp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N,M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// arr 초기화
		arr = new int[N+1];
		dp = new int[N+1];
		
		// N개의 수 입력
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		// 미리 합 구해놓기
		makeDp();
		
		// 구간 i,j 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 구간합
			sb.append(sum(a,b)).append("\n");
		}
		System.out.println(sb);
	}
	//미리 합 구해놓기
	static void makeDp() {
		for(int i=1; i<=N; i++) {
			dp[i] = dp[i-1] + arr[i];
		}
	}
	//구간합
	static int sum(int a,int b) {
		return dp[b]-dp[a-1];
	}
}