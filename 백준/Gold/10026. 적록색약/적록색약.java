import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	
	static int cnt;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new char[N][N];
		visited = new boolean[N][N];
		cnt = 0;

		for (int i = 0; i < N; i++) { // 배열 입력받기
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		sb.append(cnt+" ");
		
		visited = new boolean[N][N];
		cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j]=='G') {
					map[i][j]='R';
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
		br.close();
	}
	static void bfs(int r, int c) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		char color=map[r][c];
		visited[r][c]=true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			r = now[0];
			c = now[1];
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(0<=nr&&nr<N && 0<=nc&&nc<N && map[nr][nc]==color && !visited[nr][nc]) {
					visited[nr][nc]=true;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
	}
}