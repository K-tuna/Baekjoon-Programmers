import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] g;
	static boolean[] v;
	static int[][] dist;
	static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=0;
		while(true) {
			N=Integer.parseInt(br.readLine());
			if(N==0) break;
			g=new int[N][N];
			v=new boolean[N];
			dist=new int[N][N];
			cnt++;
			
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					g[i][j]=Integer.parseInt(st.nextToken());
					dist[i][j] = -1;
				}
			}
			dijkstra(cnt);
		}
		System.out.println(sb);
	}
	
	static void dijkstra(int cnt){
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0,0,g[0][0]));
		dist[0][0] = g[0][0];
		
		while(!pq.isEmpty()) {
			Node a = pq.poll();
			if(a.row == N-1 && a.col == N-1) {
				sb.append("Problem ").append(cnt).append(": ").append(a.loopy).append("\n");
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nr = a.row + dr[i];
				int nc = a.col + dc[i];
				
				if(nr<0||nc<0||nr>=N||nc>=N)
					continue;
				if(dist[nr][nc] >= a.loopy + g[nr][nc])
					continue;
				
				dist[nr][nc] = a.loopy + g[nr][nc];
				pq.offer(new Node(nr,nc,dist[nr][nc]));
			}
		}
		
	}
	
}
class Node implements Comparable<Node>{
	int row, col, loopy;
	
	Node(int row, int col, int loopy){
		this.row = row;
		this.col = col;
		this.loopy = loopy;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.loopy - o.loopy;
	}
	
}