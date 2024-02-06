import java.io.*;
import java.util.*;

public class Solution {
	static int N,vc; // 숫자의 개수
	static int[][] number;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dr={1,-1,0,0,-1,-1,1,1};
	static int[] dc={0,0,1,-1,-1,1,1,-1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			arr=new char[N][N]; // 원본 배열
			number=new int[N][N]; //칸 기준으로 주변 지뢰 갯수
			visited=new boolean[N][N]; // 방문배열
			ArrayDeque<int[]> bomb = new ArrayDeque<>(); // 지뢰좌표
			int answer=0; // 답
			int first=0; // 먼저 누를곳
			int total=N*N; // 전체 배열 수
			int last=0;
			vc=0;
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {					
					arr[i][j]=str.charAt(j);
					if(arr[i][j]=='*') {
						bomb.offerLast(new int[]{i,j});
						visited[i][j]=true;
						vc++;
					}
				}
			}
            
			while(!bomb.isEmpty()) { // 지뢰 근처에 1씩 증가
				int[] now = bomb.poll();
				for(int d=0; d<8; d++) {
					int nr = now[0] + dr[d];					
					int nc = now[1] + dc[d];
					if(0<=nr&&nr<N && 0<=nc&&nc<N && arr[nr][nc]=='.') {
						number[nr][nc]++;
					}
				}
			}
			
			for(int i=0; i<N; i++) { // bfs로 먼저 누를곳 누르기 
				for(int j=0; j<N; j++) {
					if(arr[i][j]=='.' && !visited[i][j] && number[i][j]==0) {
						bfs(i,j);
						first++;
					}
				}
			}
			
//			for(int i=0; i<N; i++) { // 나머지 누르기 
//				for(int j=0; j<N; j++) {
//					if(!visited[i][j]) {
//						last++;
//					}
//				}
//			}
			
			answer = total- vc + first;
			
//			System.out.println("answer: "+answer+" first: "+first);
//			answer = first+last;
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int r, int c) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offerLast(new int[] {r,c});
		visited[r][c]=true;
		vc++;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int d=0; d<8; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				
				if(0<=nr&&nr<N && 0<=nc&&nc<N && !visited[nr][nc] && arr[nr][nc]=='.') {
					visited[nr][nc]=true;
					vc++;
					if(number[nr][nc]==0) {
						queue.offerLast(new int[] {nr,nc});
					}
				}
			}
		}
	}
}