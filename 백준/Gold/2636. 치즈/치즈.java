import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	static int total_cheese;
	static int before_cheese;
	static int tmp_cheese;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		total_cheese=0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					total_cheese++;
			}
		}
		int time=0;
		while(total_cheese>0) {
			visited = new boolean[N][M];
			before_cheese=total_cheese;
			tmp_cheese=0;
			bfs(0,0);
			total_cheese-=tmp_cheese;
			time++;
		}
		sb.append(time).append("\n").append(before_cheese);
		
		System.out.println(sb);
		br.close();
	}
	static void bfs(int r, int c) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			r = now[0];
			c = now[1];
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(0<=nr&&nr<N && 0<=nc&&nc<M && !visited[nr][nc]) {
					if(map[nr][nc]==1) {
						map[nr][nc]=0;	
						tmp_cheese++;
					}else {
						queue.offer(new int[] {nr,nc});						
					}
					visited[nr][nc]=true;
				}
			}
		}
	}
}