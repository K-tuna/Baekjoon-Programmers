import java.io.*;
import java.util.*;

public class Solution {
	static int N,M, ans, tcnt, scnt;
	static int[][] graph;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			graph=new int[N+1][N+1];
			ans=0;

			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int from=Integer.parseInt(st.nextToken());
				int toto=Integer.parseInt(st.nextToken());
				graph[from][toto]=1;
			}
			
			for(int i=1; i<N+1; i++) {
				tcnt = 0;
				scnt = 0;
				taller(i, new boolean[N+1]);
				shorter(i, new boolean[N+1]);
				if(tcnt + scnt == N-1)
					ans++;
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static void taller(int from, boolean[] visited) {
		visited[from] = true;
		for(int i=1; i<N+1; i++) {
			if(!visited[i] && graph[from][i] == 1) {
				taller(i, visited);
				tcnt++;
			}
		}
	}
	static void shorter(int to, boolean[] visited) {
		visited[to] = true;
		for(int i=1; i<N+1; i++) {
			if(!visited[i] && graph[i][to] == 1) {
				shorter(i, visited);
				scnt++;
			}
		}
	}
	
}