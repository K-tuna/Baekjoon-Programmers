import java.io.*;
import java.util.*;

public class Main {
	static int N,L,R;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int day=0;
		int isMove = 1;
		while (isMove>0) {
			isMove = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && bfs(i, j, arr[i][j]))
						isMove++;
				}
			}
			if(isMove>0)
				day++;
		}
		sb.append(day);
		System.out.println(sb);
	}
	
	static boolean bfs(int i, int j, int num) { //num = 인구수
		int sum=arr[i][j],cnt=1;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		ArrayDeque<int[]> union = new ArrayDeque<>();
		queue.offer(new int[] {i,j});
		union.offer(new int[] {i,j});
		visited[i][j]=true;
		
		while(!queue.isEmpty()) { // bfs 부분
			int[] now = queue.poll();
			int r = now[0]; int c = now[1];
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (0 <= nr && nr < N && 0 <= nc && nc < N
						&& !visited[nr][nc] 
						&& L<=Math.abs(arr[nr][nc]-arr[r][c])&&Math.abs(arr[nr][nc]-arr[r][c])<=R) {
					int nowNum = arr[nr][nc];
					int[] tmp = {nr,nc};
					queue.offer(tmp);
					union.offer(tmp);
					sum += nowNum;
					cnt++;
					visited[nr][nc]=true;
				}
			}
		}
		int avg = sum/cnt; // 연합 평균 구하기
		
		boolean result = false;
		for(int[] uni: union) { // 연합에 평균 대입
			if (arr[uni[0]][uni[1]]!=avg) {
				arr[uni[0]][uni[1]]=avg;
				result = true;
			}	
		}
		return result;
	}
}