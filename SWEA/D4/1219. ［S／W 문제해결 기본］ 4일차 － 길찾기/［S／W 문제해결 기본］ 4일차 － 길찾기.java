import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] g;
	static boolean[] v;
	static int ans=0;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			g=new int[100][100];
			v=new boolean[100];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int from = Integer.parseInt(st.nextToken());
				int toto = Integer.parseInt(st.nextToken());						
				g[from][toto]=1;
			}
			
//			dfs(0);
			bfs(0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static void bfs(int i) {
		ArrayDeque<Integer> q=new ArrayDeque<>();
		v[i]=true;
		q.offer(i);
		while(!q.isEmpty()) {
			i=q.poll();
			if(g[i][99]==1) {
//				sb.append(i+"\n");
				ans=1;
				return;
			}
			for(int j=0; j<100; j++) {// 0->N
				if(g[i][j]!=0 && !v[j]) {//
					v[j]=true;
					q.offer(j);
				}
			}
		}
		ans=0;
		return;
	}
	
	static void dfs(int i) {
		if(g[i][99]==1) {
			ans=1;
			sb.append(i+"\n");
			return;
		}
		v[i]=true;
		for(int j=0; j<100; j++) {// 0->N
			if(g[i][j]!=0 && !v[j]) {//
				dfs(j);
//				v[j]=false;
			}
		}
	}
}