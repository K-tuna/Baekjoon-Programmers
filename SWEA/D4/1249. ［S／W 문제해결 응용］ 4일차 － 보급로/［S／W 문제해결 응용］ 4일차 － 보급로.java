import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int r;
	int c;
	int w;
	public Node(int r, int c, int w) {
		this.r = r;
		this.c = c;
		this.w = w;
	}
	@Override
	public int compareTo(Node o) {
		return this.w-o.w;
	}
}

public class Solution {
	static int N;
	static int[][] g;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static boolean[][] v;
	static int min;
	static int[][] ans;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			g=new int[N][N];
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					g[i][j]=Integer.parseInt(str.charAt(j)+"");
				}
			}
			
			v=new boolean[N][N];
			min = Integer.MAX_VALUE;
			ans = new int[N][N];
			
			for(int i=0; i<N; i++)
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			ans[0][0]=0;
			
			bfs(0,0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int r, int c) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(r,c,0));
		v[r][c]=true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			r = node.r;
			c = node.c;
			int w = node.w;
			
			if(r==N-1 && c==N-1)
				min=min>w ? w:min;
				
			if(min<=w)
				continue;
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(0<=nr&&nr<N && 0<=nc&&nc<N) {
					int nw = w + g[nr][nc];
					if(!v[nr][nc] || nw < ans[nr][nc]) {
						v[nr][nc] = true;
						ans[nr][nc] = nw;
						q.offer(new Node(nr,nc,nw));						
					}
				}
			}
		}
	}
}