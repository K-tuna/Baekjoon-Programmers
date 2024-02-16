import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[][] map;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		bfs(0,0);
		sb.append(map[N-1][M-1]);
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
				if(0<=nr&&nr<N && 0<=nc&&nc<M && map[nr][nc]==1) {
					map[nr][nc]=map[r][c]+1;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
	}
}