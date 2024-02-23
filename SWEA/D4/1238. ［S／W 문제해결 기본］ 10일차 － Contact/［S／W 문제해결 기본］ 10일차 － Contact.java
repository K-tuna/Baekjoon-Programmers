import java.io.*;
import java.util.*;

public class Solution {
	static int N,start;
	static int[][] g;
	static int[] v;
	static int max;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			g=new int[101][101];
			v=new int[101];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int from=Integer.parseInt(st.nextToken());
				int toto=Integer.parseInt(st.nextToken());
				g[from][toto]=1;
			}
			int ans = bfs(start);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb);
		br.close();
	}
	
	static int bfs(int i) {
		max=0;
		ArrayDeque<Integer> q=new ArrayDeque<>();
		int depth = 1;
		v[i]=depth;
		q.offer(i);
		while(!q.isEmpty()) {
			i=q.poll();
			for(int j=0; j<101; j++) {
				if(g[i][j]==1 && v[j]==0) {
					v[j]=v[i]+1;
					q.offer(j);
				}
			}
			depth = Math.max(depth, v[i]);
		}
		
		for(int a=100; a>=0; a--) {
			if(v[a]==depth) {
				return a;
			}
		}
		return -1;
	}
}