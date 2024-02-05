import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		// 맵 정보 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = Integer.MIN_VALUE;
		for(int k=0; k<=100; k++) {
			int cnt=0;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] > k && !visited[i][j]) {
						bfs(i,j,k);
						cnt++;
					}
				}
			}
			if(max<cnt) max=cnt;
		}
		sb.append(max);
		System.out.println(sb);
	}
	
	static void bfs(int r, int c, int height) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {r,c});
		
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int d=0; d<4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]>height && !visited[nr][nc]) {
					queue.add(new int[] {nr, nc});
					visited[nr][nc]=true;
				}
			}
		}
	}
}