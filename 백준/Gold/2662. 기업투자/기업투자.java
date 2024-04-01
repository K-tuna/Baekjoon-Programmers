import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	static int[][] info,dp,invest;
	static int[] path;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		info = new int[N+1][M+1];
		invest = new int[N+1][M+1];
		path = new int[M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			for(int j=1; j<=M; j++) {
				int benefit = Integer.parseInt(st.nextToken());
				info[i][j] = benefit;
			}
		}
		
		dp = new int[N+1][M+1];
		
		solve();
		getPath(N,M);
		System.out.println(dp[N][M]);
		for(int i=1; i<= M; i++) {
			System.out.print(path[i]+" ");
		}
	}

	static void solve() {
		for(int j=1; j<=M; j++) {
			for(int i=0; i<=N; i++) {
				for(int k=N-i; k>=0; k--) {
					// j기업까지 i+k원을 투자한 이익보다
					// j-1기업까지 k원을 투자한 이익 + j기업에 i원을 투자한 금액이 더 크다면
					if(dp[i+k][j] < dp[k][j-1] + info[i][j]) {
						dp[i+k][j] = dp[k][j-1] + info[i][j];
						invest[i+k][j]=i; //투자 액수 저장 (경로 추적을 위해서)
					}
				}
			}
		}
	}
	
	static void getPath(int n, int m) {
		if(m==0) 
			return;
		path[m] = invest[n][m];
		getPath(n - path[m], m-1);
	}
}