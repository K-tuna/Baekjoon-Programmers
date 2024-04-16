import java.util.*;
import java.io.*;

public class Main {
	
	static class Node implements Comparable<Node>{
		int r,c,w;
		
		public Node(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
		
	}
	static int N;
	static int[][] g;
	static int[][] dist;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			g=new int[N][N];
			dist=new int[N][N];
			cnt++;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					g[i][j]=Integer.parseInt(st.nextToken());
					dist[i][j]=-1;
				}
			}
			dijstra(cnt);
		}
		System.out.println(sb);
		
	}
	static void dijstra(int cnt) {
		PriorityQueue<Node> pq=new PriorityQueue<>();
		dist[0][0]=g[0][0];
		pq.offer(new Node(0,0,g[0][0]));
		
		while(!pq.isEmpty()) {
			Node node=pq.poll();
			if(node.r==N-1 && node.c==N-1) {
				sb.append("Problem ").append(cnt).append(": ").append(node.w).append("\n");
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N)
					continue;
				if( dist[nr][nc] < node.w + g[nr][nc]) {
					dist[nr][nc] = node.w + g[nr][nc];
					pq.offer(new Node(nr,nc,dist[nr][nc]));
				}
			}
		}
	}
}