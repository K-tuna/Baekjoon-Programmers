import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int end,w;
		public Node(int end, int w) {
			this.end=end;
			this.w=w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w; //최장경로
		}
	}
	
	static int V,E,X;
	static final int INF = 100_000_000;
	
	static boolean[] v;
	static int[] dist;
	static List<Node>[] listA;
	static List<Node>[] listB;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		listA = new List[V+1];
		listB= new List[V+1];
		
		for(int i=1; i<V+1; i++) {
			listA[i]=new ArrayList<>();
			listB[i]=new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			listA[start].add(new Node(end,weight));
			listB[end].add(new Node(start,weight));
		}
		
		int[] go = dijkstra(listA, X);
		int[] back = dijkstra(listB, X);
		
		int res = Integer.MIN_VALUE;
		for(int i=1; i<V+1; i++) {
			int dis = go[i] + back[i];
			if(dis>res) res = dis;
		}
		System.out.println(res);
	}
	
	static int[] dijkstra(List<Node>[] list, int A) { //A: 시작 B: 도착
		v = new boolean[V+1];
		dist = new int[V+1];
		for(int i=1; i<V+1; i++) {
			dist[i]=INF;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[A]=0;
		pq.add(new Node(A,0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int end = curNode.end;
			
			if(v[end]) continue;
			v[end]=true;
			
			for(Node node : list[end]) {
				if( dist[node.end] > dist[end] + node.w) {
					dist[node.end] = dist[end] + node.w;
					pq.add(new Node(node.end, dist[node.end]));
				}
			}
		}
		return dist;
	}
}