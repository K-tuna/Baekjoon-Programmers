import java.io.*;
import java.util.*;

public class Main {
	static char[][][] g;
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	
	static Queue<int[]> q;
	
	static int R,C,N;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// 0: 초기
		// 1: 한번 터진후
		// 2: 두번 터진후
		// 3: O으로 가득찬 경우
		g = new char[R][C][4];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				for(int c=1; c<4; c++) {
					g[i][j][c]='O';
				}
			}
		}		
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				g[i][j][0]=str.charAt(j);
			}
		} // 반복
		
		for(int c=0; c<2; c++) {
			q = new ArrayDeque<>();
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(g[i][j][c]=='O') {
						q.offer(new int[] {i,j});
					}
				}
			}
			bfs(c+1);
		}
		
		if(N==1) {
			printArr(g,0);
		}else if(N%2==0) {
			printArr(g, 3);
		}else if(N%4==3) {
			printArr(g, 1);
		}else if(N%4==1) {
			printArr(g, 2);
		}

		System.out.println(sb);	
	}
	static void bfs(int c) {
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int i = now[0];
			int j = now[1];
			g[i][j][c]='.';
			for(int d=0; d<4; d++) {
				int nr = i + dr[d];
				int nc = j + dc[d];
				
				if(0<=nr&&nr<R && 0<=nc&&nc<C && g[nr][nc][c] == 'O') {
					g[nr][nc][c]='.';
				}
			}
		}
	}
	
	static void printArr(char[][][] arr, int idx) {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sb.append(arr[i][j][idx]);
			}
			sb.append("\n");
		}
	}
}