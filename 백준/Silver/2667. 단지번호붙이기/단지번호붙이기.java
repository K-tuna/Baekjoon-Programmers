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
			String[] a = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(a[j]);
			}
		}
		
		int cnt=0;
		visited = new boolean[N][N];
		ArrayList<Integer> home = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					home.add(bfs(i,j));
					cnt++;
				}
			}
		}
		home.sort(null);
		sb.append(cnt).append("\n");
		for(int a: home)
			sb.append(a).append("\n");
		System.out.println(sb);
	}
	
	static int bfs(int r, int c) {
		int cnt=1;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {r,c});
		
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int d=0; d<4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]==1 && !visited[nr][nc]) {
					queue.add(new int[] {nr, nc});
					visited[nr][nc]=true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}