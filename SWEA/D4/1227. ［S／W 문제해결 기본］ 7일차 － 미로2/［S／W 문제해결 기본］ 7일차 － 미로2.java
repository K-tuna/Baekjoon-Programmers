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

		for(int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int si=0; //출발지점 si,sj
			int sj=0;
			
			map=new int[100][100]; // 원본 배열
			for(int i=0; i<100; i++) {
				String str = br.readLine();
				for(int j=0; j<100; j++) {
					map[i][j] = str.charAt(j)-'0';
					if(map[i][j]==2) {
						si = i;
						sj = j;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(bfs(si,sj)).append("\n");
		}
		System.out.println(sb);
	}
	
	static int bfs(int i, int j) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offerLast(new int[] {i,j});
		map[i][j]=1;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(0<=nr&&nr<100 && 0<=nc&&nc<100 && map[nr][nc]!=1) {
					if(map[nr][nc]==3) { // 3에 도착하면
						return 1; // 1 리턴
					}
					map[nr][nc]=1; // 1로 바꿔줌
					queue.offerLast(new int[] {nr,nc});
				}
			}
		}
		return 0; // 도착 못하면 0 리턴
	}
}