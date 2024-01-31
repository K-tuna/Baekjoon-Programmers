import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] snail;
	static int[] dr = {0,1,0,-1}; // 우 하 좌 상
	static int[] dc = {1,0,-1,0};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//T 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		//입력
		for(int tc=1; tc<=T; tc++) {
			//N입력
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int answer = 0;
			snail = new int[N][N];

			makeSnail();
			sb.append("#").append(tc).append("\n");
			printSnail();
			
		}
		System.out.println(sb);
	}
	
	//snail배열 채우기
	static public void makeSnail() {
		int cnt = 1; //채우는 숫자
		int idx = 0; //방향 인덱스
		int nr=0,nc=-1;
		for(int i=1; i<=N*N; i++) {
			int tmpR = nr + dr[idx%4];
			int tmpC = nc + dc[idx%4];
			if (tmpR < 0 || tmpR >= N || tmpC <0 || tmpC >= N || snail[tmpR][tmpC]!=0) {
				nr += dr[(++idx)%4];
				nc += dc[(idx)%4];
			} else {
				nr = tmpR;
				nc = tmpC;
			}
			snail[nr][nc] = i;
		}
	}
	// snail 배열 출력
	static public void printSnail() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(snail[i][j]).append(" ");
			}
			sb.append("\n");
		}
	}
}