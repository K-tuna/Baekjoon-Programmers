import java.io.*;
import java.util.*;

public class Solution {
	static class Edge implements Comparable<Edge>{
		int from,to,weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return  Integer.compare(this.weight, o.weight) /* this.weight-o.weight */;
		}
	}
	
	static int V,E;
	static Edge[] edgeList;
	static int[] parents;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edgeList = new Edge[E];
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken())-1;
				int B = Integer.parseInt(st.nextToken())-1;
				int C = Integer.parseInt(st.nextToken());
				edgeList[i]=new Edge(A,B,C);
			}
			
			Arrays.sort(edgeList);
			
			make();
			
			long weight = 0;
			int cnt = 0;
			for(Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {
					weight += edge.weight;
					if(++cnt==V-1) break;					
				}
			}
			sb.append("#").append(tc).append(" ").append(weight).append("\n");
			
		}
		System.out.println(sb);
		br.close();
	}
	
	static void make() {
		parents = new int[V];
		for(int i=0; i<V; i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}