import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int round = Math.min(N, M)/2;
		
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int t=0;t<R;t++) {
			for(int i=0;i<round;i++) {
				int cnt = 0;
				int now = map[i][i];
				int x = i, y = i;
				while(cnt<4) {
					int nx = x +dx[cnt];
					int ny = y +dy[cnt];
					
					if(nx>=i && ny>=i && nx<N-i && ny<M-i ) {
						map[x][y] = map[nx][ny];
						x = nx;
						y = ny;
					}
					else {
						cnt++;
					}
				}
				map[i+1][i] = now;
			}
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);;
		br.close();
	}
}