import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int vertex,weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", next=" + next + "]";
		}		
	}
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		final int INF = Integer.MAX_VALUE;
		
		Node[] adjList = new Node[V+1];
		int[] minDistance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int toto = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(toto, weight, adjList[from]);
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		
		Arrays.fill(minDistance, INF);
		minDistance[start] = 0;
		
		int min=0, stopOver=0;
		for(int i=1; i<V+1; i++) {
			min = INF;
			stopOver = -1;
			
			for(int j=1; j<V+1; j++) {
				if(!visited[j] && min>minDistance[j]) {
					min = minDistance[j];
					stopOver = j;
				}
			}
			
			if(stopOver==-1) break;
			visited[stopOver]=true;
			
			for(Node temp=adjList[stopOver]; temp!=null; temp=temp.next) {
				if(minDistance[temp.vertex] > min+temp.weight) {
					minDistance[temp.vertex] = min+temp.weight;
				}
			}
		}
		System.out.println(minDistance[end]);
	}
}