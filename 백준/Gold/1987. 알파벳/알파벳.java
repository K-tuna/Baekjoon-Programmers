import java.io.*;
import java.util.*;

public class Main {
	static int R,C;
	static int max;
	static int[][] map;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		v = new boolean[26];
		max=0;
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=str.charAt(j)-'A';
			}
		}

		dfs(0,0,1);
		sb.append(max);
		System.out.println(sb);
		br.close();
	}
	static void dfs(int r, int c,int cnt) {
	
		v[map[r][c]]=true;
		max=Math.max(max, cnt);

		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(0<=nr&&nr<R && 0<=nc&&nc<C) {
				if(!v[map[nr][nc]]) {
					dfs(nr,nc,cnt+1);
					v[map[nr][nc]]=false;
				}
			}
		}
	}
}