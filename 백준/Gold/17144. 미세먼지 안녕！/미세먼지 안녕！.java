import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int R,C,T;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static int[][] map;
	static int cleaner = -1;
	static ArrayDeque<Dust> dusts;
	static class Dust{
		int x,y,w;
		
		public Dust(int x, int y, int w) {
			this.x=x;
			this.y=y;
			this.w=w;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for(int i=0;i<R;i++) { // 방 입력받기
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(cleaner == -1 && map[i][j]==-1) { // 공기청정기 위치 입력
					cleaner = i;
				}
			}
		}
		
		for(int time=0; time<T; time++) {
			checkDust();
			spread();
			operate();
		}
		
		int res=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == -1) continue;
				res += map[i][j];
			}
		}
		sb.append(res);
		System.out.println(sb);
		br.close();
	}
	static void checkDust() {
		dusts = new ArrayDeque<>();
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]==-1 || map[i][j]==0) continue;
				// 미세먼지가 있는 공간과  미세먼지 양
				dusts.add(new Dust(i,j,map[i][j]));
			}
		}
	}
	static void spread() {
		while(!dusts.isEmpty()) {
			Dust now = dusts.poll();
			if(now.w<5) continue;
			int amountOfSpread = now.w/5;
			int cnt=0;
			for(int d=0; d<4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if(nx<0 || nx>=R || ny<0 || ny>=C) continue;
				if(map[nx][ny]==-1) continue;
				
				map[nx][ny] += amountOfSpread;
				++cnt;
			}
			
			map[now.x][now.y] -= amountOfSpread*cnt;
		}
	}
	static void operate() {
		int top = cleaner;
		int down = cleaner+1;
		
		for(int i=top-1; i>0; i--)
			map[i][0] = map[i-1][0];
		
		for(int i=0; i<C-1; i++)
			map[0][i] = map[0][i+1];
		
		for(int i=0; i<top; i++)
			map[i][C-1] = map[i+1][C-1];
		
		for(int i=C-1; i>1; i--)
			map[top][i] = map[top][i-1];
		map[top][1]=0;
		
		
		for(int i=down+1; i<R-1; i++)
			map[i][0] = map[i+1][0];
		
		for(int i=0; i<C-1; i++)
			map[R-1][i] = map[R-1][i+1];
		
		for(int i=R-1; i>down; i--)
			map[i][C-1] = map[i-1][C-1];
		
		for(int i=C-1; i>1; i--)
			map[down][i] = map[down][i-1];
		map[down][1]=0;
	}
}