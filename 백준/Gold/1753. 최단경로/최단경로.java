import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int end;
		int w;
		
		public Node(int end, int w) {
			this.end = end;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static int V,E,K;
	static final int INF = 100_000_000;
	
	static boolean[] v;
	static int[] dist;
	static List<Node>[] list;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		v = new boolean[V+1];
		dist = new int[V+1];
		list = new List[V+1];
		
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<>();
			dist[i] = INF;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end,weight));
		}
		
		dijkstra();
		
		for(int i=1; i<=V; i++) {
			if(dist[i]==INF) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		
		System.out.print(sb);
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[K] = 0;
		pq.offer(new Node(K,0));
		
		while(!pq.isEmpty()) {
			int end = pq.poll().end;
			
			if(v[end]) continue;
			v[end] = true;
			
			for(Node n : list[end]) {
				if( dist[n.end] > dist[end] + n.w) {
					dist[n.end] = dist[end] + n.w;
					pq.offer(new Node(n.end, dist[n.end]));
				}
			}
		}
	}
}