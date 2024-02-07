import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map; //배열
	static int[] dr={1,-1,0,0}; //상하좌우
	static int[] dc={0,0,1,-1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			int max=0,cnt=0;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map=new int[N][N]; // 원본 배열
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cnt=bfs(i,j);
					if(max==cnt) {
						pq.offer(map[i][j]);
					}else if(max<cnt) {
						max=cnt;
						pq.clear();
						pq.offer(map[i][j]);
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(pq.poll()).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	static int bfs(int i, int j) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offerLast(new int[] {i,j});
		int cnt=1;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(0<=nr&&nr<N && 0<=nc&&nc<N && map[nr][nc]==map[r][c]+1) {
					cnt++;
					queue.offerLast(new int[] {nr,nc});
				}
			}
		}
		return cnt;
	}
}