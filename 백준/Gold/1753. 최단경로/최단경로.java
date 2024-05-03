import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int end, w;
		
		public Node(int end, int w) {
			this.end = end;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
		
	}
	static boolean[] v;
	static int[] dist;
	static List<Node>[] list;
	
	static int V,E,K;
	static final int INF = 100_000_000;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
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
			if(dist[i] == INF) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		System.out.println(sb);
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[K]=0;
		pq.offer(new Node(K,0));
		
		while(!pq.isEmpty()) {
			int end = pq.poll().end;
			
			if(v[end]) continue;
			v[end] = true;
			
			for(Node node: list[end]) {
				if(dist[node.end] > dist[end] + node.w) {
					dist[node.end] = dist[end] + node.w;
					pq.offer(new Node(node.end, dist[node.end]));
				}
			}
		}
	}
}