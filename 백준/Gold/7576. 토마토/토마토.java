import java.io.*;
import java.util.*;

public class Main {
	static int N,M,day=0,answer; // 숫자의 개수
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr={1,-1,0,0};
	static int[] dc={0,0,1,-1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
			
		arr=new int[N][M]; // 원본 배열
		visited=new boolean[N][M]; // 방문배열
		ArrayDeque<int[]> start = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int full = Integer.parseInt(st.nextToken());
				arr[i][j]= full;
				if(full==1) {
					start.offerLast(new int[] {i,j});
					visited[i][j]=true;
				}
			}
		}
		
		bfs(start);
		flag: for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==0) {
					answer=0;
					break flag;
				}
					
			}
		}
		sb.append(answer-1);
		System.out.println(sb);
	}
	
	static void bfs(ArrayDeque<int[]> queue) {
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			answer=arr[r][c];
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(0<=nr&&nr<N && 0<=nc&&nc<M && !visited[nr][nc] && arr[nr][nc]==0) {
					visited[nr][nc]=true;
					answer=arr[nr][nc]=arr[r][c]+1;
					queue.offerLast(new int[] {nr,nc});
				}
			}
		}
	}
}