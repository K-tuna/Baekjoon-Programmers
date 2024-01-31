import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[][] arr;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N,M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// arr 초기화
		arr = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		
		// N개의 수 입력
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());				
			}
		}
		// 미리 합 구해놓기
		makeDp();
		
		// 구간 i,j 입력
		for(int k=0; k<M; k++) {
			st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// 구간합
			sb.append(sum(x1, y1, x2, y2)).append("\n");
		}
		System.out.println(sb);
	}
	//미리 합 구해놓기
	static void makeDp() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				//         arr[i][j] + dp의 왼쪽 + dp의 위 - dp의 왼쪽위(2번 더해주는 거기때문에 한번 빼줌)
				dp[i][j] = arr[i][j] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];				
			}
		}
	}
	//구간합
	static int sum(int x1,int y1,int x2,int y2) {
		return dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
	}
}