import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr= {-1,0,0,1}; //상 좌 우 하
	static int[] dc= {0,-1,1,0};
	
	static int sharkSize=2;
	static int sharkEat=0;
	static int move=0;
	static int[] cur;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// N 입력
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
//		int starti=0;
//		int startj=0;
		
		//배열 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					cur = new int[] {i,j};
					map[i][j]=0;
				}
			}
		}
		bfs();
		sb.append(move);
		
        System.out.println(sb);
	}
	
	static void bfs() {
		while(true) {
			PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) ->
			o1[2] != o2[2] ? 
					Integer.compare(o1[2], o2[2]) :
						(o1[0] != o2[0] ? 
								Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])));
			
			visited=new boolean[N][N];
			que.offer(new int[] {cur[0],cur[1],0});
			
			boolean ck = false;
			visited[cur[0]][cur[1]]=true;
			
			while(!que.isEmpty()) {
				cur = que.poll();
				int r = cur[0];
				int c = cur[1];
				int m = cur[2];
				
				if(map[r][c]!=0 && map[r][c] < sharkSize ) {
					map[r][c]=0;
					sharkEat++;
					move += m;
					ck = true;
					break;
				}
				
				for(int d=0; d<4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || map[nr][nc] > sharkSize)
                        continue;
					que.offer(new int[] {nr,nc,m+1});
					visited[nr][nc]=true;
					
				}
			}
			if(!ck)
				break;
			
			if(sharkSize == sharkEat) {
				sharkSize++;
				sharkEat=0;
			}
		}
	}
}