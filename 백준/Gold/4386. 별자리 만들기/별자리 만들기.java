import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int end;
		double w;
		public Node(int end, double w) {
			this.end=end;
			this.w=w;
		}
		@Override
		public int compareTo(Node o) {
			return Double.compare(this.w, o.w);
		}
	}
	static double total;
	static List<Node>[] list;
	static double[][] stars;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		list = new ArrayList[V];
		stars = new double[V][2];
		v = new boolean[V];
		
		for(int i=0; i<V; i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0; i<V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			stars[i][0] = a;
			stars[i][1] = b;
		}
		
		for(int i=0; i<V; i++) {
			for(int j=0; j<V; j++) {
				if(i!=j) {
					double w = Math.sqrt(Math.pow(stars[i][0]-stars[j][0],2) + Math.pow(stars[i][1]-stars[j][1],2));
					list[i].add(new Node(j,w));
				}
			}
		}
		prim(0);
		System.out.println(String.format("%.2f",total));
	}
	static void prim(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int end = now.end;
			double w = now.w;
			
			if(v[end]) continue;
			v[end] = true;
			total += w;
			
			for(Node node: list[end]) {
				if(!v[node.end]) {
					pq.offer(node);
				}
			}
		}
	}
}