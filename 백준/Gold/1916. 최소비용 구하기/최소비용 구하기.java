import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int end,w;
		public Node(int end,int w) {
			this.end=end;
			this.w=w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}
	static int V,E,A,B;
	static final int INF = 100_000_000;
	
	static boolean[] v;
	static int[] dist;
	static List<Node>[] list;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		v = new boolean[V+1];
		dist = new int[V+1];
		list = new List[V+1];
		for(int i=1; i<V+1; i++) {
			dist[i] = INF;
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end,weight));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		dijkstra();
		System.out.println(dist[B]);
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[A] = 0;
		pq.add(new Node(A,0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int end = curNode.end;
			
			if(v[end]) continue;
			v[end] = true;
			
			for(Node node : list[end]) {
				if( dist[node.end] > dist[end] + node.w) {
					dist[node.end] = dist[end] + node.w;
					pq.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}
}