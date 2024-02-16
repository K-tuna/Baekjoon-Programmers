import java.io.*;
import java.util.*;

public class Main {
	static int N,M,V;
	static List<Integer>[] graph;
	static boolean[] v;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new List[N+1];
		for(int i=0; i<N+1; i++)
			graph[i]=new ArrayList<>();
		v=new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int toto = Integer.parseInt(st.nextToken());
			graph[from].add(toto);
			graph[toto].add(from);
		}
		for(List<Integer> g: graph) {
			g.sort(null);
		}
		dfs(V);
		sb.append("\n");
		
		v=new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);
		br.close();
	}
	static void dfs(int i) {
		v[i]=true;
		sb.append(i+" ");
		for(int j: graph[i]) {
			if(!v[j]) {
				dfs(j);
			}
		}
	}
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i]=true;
		q.offer(i);
		while(!q.isEmpty()) {
			i=q.poll();
			sb.append(i+" ");
			for(int j:graph[i]) {
				if(!v[j]) {
					v[j]=true;
					q.offer(j);
				}
			}
		}	
	}
}