import java.io.*;
import java.util.*;

public class Solution {
	static int N,M;
	static List<Integer>[] g;
	static boolean[] v;
	static int ans;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			ans=0;
			g=new List[N+1];
			v=new boolean[N+1];
			for(int i=0; i<N+1; i++)
				g[i]=new ArrayList<>();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int toto = Integer.parseInt(st.nextToken());
				g[from].add(toto);
				g[toto].add(from);
			}
			
			for(int i=1; i<N+1; i++) {
				if(!v[i]) {
					dfs(i);
					ans++;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void dfs(int i) {
		v[i]=true;
		for(int j:g[i]) {
			if(!v[j]) {
				dfs(j);
			}
		}
	}
}