import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static List<Integer>[] g;
	static boolean[] v;
	static int ans=0;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		g=new List[N];
		v=new boolean[N];
		for(int i=0; i<N; i++)
			g[i]=new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int toto = Integer.parseInt(st.nextToken());
			g[from].add(toto);
			g[toto].add(from);
		}
		
		for(int i=0; i<N; i++) {
			v=new boolean[N];
			dfs(i,1);
			if(ans==1) {
				sb.append(ans);
				System.out.println(sb);
				return;
			}
		}
		sb.append(ans);
		System.out.println(sb);
		br.close();
	}
	
	static void dfs(int i, int depth) {
		if(depth==5) {
			ans=1;
//			sb.append(Arrays.toString(v)+"\n");
			return;
		}
		v[i]=true;
		for(int j:g[i]) {
			if(!v[j]) {
				dfs(j,depth+1);
			}
		}
		v[i]=false;
	}
}