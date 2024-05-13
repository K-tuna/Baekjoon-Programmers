import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node> {
		int end,w;
		
		public Node(int end, int w) {
			this.end=end;
			this.w=w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}
	static int total;
	static List<Node>[] list;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		v = new boolean[V+1];
		list = new ArrayList[V+1];
		for(int i=1; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,w));
			list[b].add(new Node(a,w));
		}
		prim(1);
		System.out.println(total);
	}
	static void prim(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int end = now.end;
			int w = now.w;
			
			if(v[end]) continue;
			v[end]=true;
			total += w;
			
			for(Node node: list[end]) {
				if(!v[node.end]) {
					pq.add(node);
				}
			}
		}
	}
}