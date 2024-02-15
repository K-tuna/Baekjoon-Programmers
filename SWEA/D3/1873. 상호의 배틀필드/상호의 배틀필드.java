import java.io.*;
import java.util.*;

public class Solution {
	static int H,W,N;
	static String cmd;
	static char[][] map;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static char[] shape = {'^','v','<','>'};
	static int tankr,tankc;
	static int dist; //방향인덱스
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			for(int i=0; i<H; i++) { // 배열입력
				String[] strArr = br.readLine().split("");
				for(int j=0; j<W; j++) {
					map[i][j]=strArr[j].charAt(0);
					char now = map[i][j];
					if(now=='<'||now=='>'||now=='^'||now=='v') {
						tankr=i; tankc=j; // 전차 위치
					}
				}
			}
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			
			setDist(map[tankr][tankc]);
			process(cmd);
			
			sb.append("#").append(tc).append(" ");
			printArr();
			
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static void process(String cmd) {
		for(int i=0; i<N; i++) {
			char c = cmd.charAt(i);
			if(c=='S') {
				shoot();
			}else{// c=='U' or c=='D' or c=='L' or c=='R'
				turn(c);
			}
		}
	}
	static void setDist(char c) {
		if(c=='U'||c=='^')
			dist=0;
		else if(c=='D'||c=='v')
			dist=1;
		else if(c=='L'||c=='<')
			dist=2;
		else //(c=='R')
			dist=3;
	}
	
	static void turn(char c) {
		setDist(c);
		map[tankr][tankc]=shape[dist];
		
		int nr = tankr + dr[dist];
		int nc = tankc + dc[dist];
		
		if(0<=nr&&nr<H && 0<=nc&&nc<W && map[nr][nc]=='.') {
			map[nr][nc]=shape[dist];
			map[tankr][tankc]='.';
			tankr=nr; tankc=nc;
		}
	}

	static void shoot() {
		int bombr = tankr;
		int bombc = tankc;
		while(true) {
			int nr = bombr + dr[dist];
			int nc = bombc + dc[dist];
			
			if(nr<0 || nr>=H || nc<0 || nc>=W || map[nr][nc]=='#') return; 
			if(map[nr][nc]=='*'){
				map[nr][nc]='.';
				return;
			}
			bombr=nr; bombc=nc;
		}
	}
	
	static void printArr() {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
//		sb.append("\n");
	}
}