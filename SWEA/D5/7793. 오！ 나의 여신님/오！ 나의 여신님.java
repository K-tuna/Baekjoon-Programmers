import java.io.*;
import java.util.*;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static char[][] g;
	static boolean[][] dv; //악마
	static boolean[][] sv; //소연
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static int[] start;
	static int[] goal;
	static ArrayDeque<int[]> dq;
	static ArrayDeque<int[]> sq;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			g=new char[N][M];
			dv=new boolean[N][M];
			sv=new boolean[N][M];
			dq=new ArrayDeque<>();
			sq=new ArrayDeque<>();
			
			for(int i=0; i<N; i++) {
				String str=br.readLine();
				for(int j=0; j<M; j++) {
					char c = str.charAt(j);
					g[i][j] = c;
					if(c == 'S') {
						start = new int[] {i,j,0};
						sv[i][j]=true;
						sq.offer(start);
					}
					else if(c=='D') {
						goal = new int[] {i,j};
					}
					else if(c=='*') {
						dq.offer(new int[] {i,j});
						dv[i][j]=true;
						sv[i][j]=true;
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			int ans = bfs();
			if(ans==-1)
				sb.append("GAME OVER").append("\n");
			else
				sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static int bfs() {
		int cannot=-1;
		int x = start[0];
		int y = start[1];
		dv[x][y] = true;
		int time = 0;
		
		while(!sq.isEmpty()) {
			ArrayDeque<int[]> nDq = new ArrayDeque<>();
			while(!dq.isEmpty()) {
				int[] now = dq.poll();
				int r = now[0];
				int c = now[1];
				for(int d=0; d<4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(0<=nr&&nr<N && 0<=nc&&nc<M && !dv[nr][nc] && g[nr][nc]!='X' && g[nr][nc]!='D') {
						nDq.offer(new int[] {nr,nc});
						dv[nr][nc]=true;
						sv[nr][nc]=true;
 					}
				}				
			}
			dq=nDq;

			ArrayDeque<int[]> nSq = new ArrayDeque<>();
			time++;
			while(!sq.isEmpty()) {
				int[] now = sq.poll();
				int r = now[0];
				int c = now[1];
//				int cnt = now[2];
				for(int d=0; d<4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(0<=nr&&nr<N && 0<=nc&&nc<M && !sv[nr][nc] && g[nr][nc]!='X' && !dv[nr][nc]) {
						if(g[nr][nc]=='D') {
							return time;
						}
						nSq.offer(new int[] {nr,nc,time});
						sv[nr][nc]=true;
					}
				}
			}
			sq=nSq;

		}
		return cannot;
	}
}