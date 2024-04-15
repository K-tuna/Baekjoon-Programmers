import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int end,w;
	
	public Node(int end, int w) {
		this.end = end;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
	
}

public class Main {
	static boolean[] visit;
	static int[] dist;
	static List<Node>[] list;
	
	static int V,E,K;
	static final int INF = 100_000_000;

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		visit = new boolean[V+1];
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
		
		dijstra();
		
		for(int i=1; i<=V; i++) {
			if(dist[i] == INF) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		System.out.println(sb);
	}
	
	static void dijstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V+1];
		dist[K] = 0;
		pq.add(new Node(K,0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int now = curNode.end;
			
			if(check[now]) continue;
			check[now] = true;
			
			for(Node node : list[now]) {
				if(dist[node.end] > dist[now] + node.w) {
					dist[node.end] = dist[now] + node.w;
					pq.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}
}