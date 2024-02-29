import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static int[][] map;
	static int[][] originMap;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] v;
	static int max;
	static ArrayDeque<int[]> virus;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map=new int[N][M];
		originMap=new int[N][M];
		virus=new ArrayDeque<>();
		max=0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				originMap[i][j]=map[i][j];
				if (map[i][j]==2) {
					virus.offer(new int[] {i,j});
				}
			}
		}
		makeWall(0);
		System.out.println(max);
		
	}
	
	static void makeWall(int cnt) {
		if(cnt==3) {
			copyMap(); // map 초기화
			bfs(virus); // bfs로 바이러스 퍼지기
			max=Math.max(max, countSafeZone()); // 안전영역 세고 max값
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(originMap[i][j]==0) {
					originMap[i][j]=1;
					makeWall(cnt+1);
					originMap[i][j]=0;					
				}
			}
		}
	}
	
	static void bfs(ArrayDeque<int[]> tmp) {
		ArrayDeque<int[]> q = new ArrayDeque<>(tmp);

		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc]==0) {
					map[nr][nc]=2;
					q.offer(new int[] {nr,nc});
				}
			}
		}
	}
	
	static int countSafeZone() {
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static void copyMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=originMap[i][j];
			}
		}
	}
}