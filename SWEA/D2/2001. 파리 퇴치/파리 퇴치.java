import java.io.*;
import java.util.*;
public class Solution {
	static int N,M;
	static int[][] arr;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N,M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
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
					makeDp(i,j); // 미리 합 구해놓기
				}
			}
			// 파리 퇴치 최댓값 구하기
			int answer = 0;
			for(int i=M; i<=N; i++) { // 마지막 좌표를 M부터 해야됨. 이유: i-M을 할것이기 때문
				for(int j=M; j<=N; j++) { // M미만으로 하면 ArrayIndexOutOfBoundsException
					answer = Math.max(answer, sum(i,j));
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	// 미리 i,j까지의 전체합 구해놓기
	static void makeDp(int i, int j) {
		//         arr[i][j] + dp의 왼쪽 + dp의 위 - dp의 왼쪽위(2번 더해주는 거기때문에 한번 빼줌)
		dp[i][j] = arr[i][j] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
	}
	// N*N구간합
	static int sum(int i, int j) {
		return dp[i][j] - dp[i][j-M] - dp[i-M][j] + dp[i-M][j-M];
	}
}