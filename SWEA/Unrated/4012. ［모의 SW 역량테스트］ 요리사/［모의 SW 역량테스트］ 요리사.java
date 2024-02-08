import java.io.*;
import java.util.*;

public class Solution {
	static int answer = Integer.MAX_VALUE;
	static int N,R;
	static int[][] ability;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			R = N/2;
			int[] arr = new int[N];
			visited = new boolean[N];
			for(int i=0; i<N; i++) {
				arr[i]=i+1;
			}
			ability = new int[N][N];
			
			// 배열 입력
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					ability[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			// 조합써야함
			combination(0, 0);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	static void combination(int cnt, int start) { // 재귀로 조합
		if(cnt == R) {
			answer = Math.min(answer, combination2());
			return ;
		}
			
		for(int i = start; i < N; i++) {
			visited[i] = true;
			combination(cnt+1, i+1);
			visited[i] = false;
		}
	}
	static int combination2() { //A와 B의 능력치 조합 구하기 (두개로 나누는 경우라 가능)
		int A = 0; //A의 능력치 합
		int B = 0; //B의 능력치 합
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) { // 어짜피 i==j일때는 0이라 그냥 더해줘도 됨
				if(visited[i] && visited[j]) {
					A += ability[i][j];
				} else if (!visited[i] && !visited[j]) {
					B += ability[i][j];
				}
			}
		}
		return Math.abs(A-B); //각 팀의 능력치 차이
	}
}