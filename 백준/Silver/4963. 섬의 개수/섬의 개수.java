import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	
	static int cnt;
	static int[] dr= {-1,1,0,0,1,-1,-1,1};
	static int[] dc= {0,0,-1,1,1,1,-1,-1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			if(N==0 && M==0) // N,M 이 
				break;
			
			map = new int[N][M];
			visited = new boolean[N][M];
			cnt=0;
			
			for(int i=0; i<N; i++) { // 배열 입력받기
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt+"\n");
		}
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
			for(int d=0; d<8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(0<=nr&&nr<N && 0<=nc&&nc<M && map[nr][nc]==1) {
					map[nr][nc]=0;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
	}
}