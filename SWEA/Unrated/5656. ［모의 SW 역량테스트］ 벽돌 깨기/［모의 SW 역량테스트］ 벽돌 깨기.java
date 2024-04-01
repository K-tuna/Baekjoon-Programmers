import java.io.*;
import java.util.*;

public class Solution {
	static int N,W,H;
	
	static int[][] g;
	static int[][] origin;
	static int[][] tmpg;
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	
	static int[] a,b;
	static int minCnt=Integer.MAX_VALUE;

	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			
			origin=new int[H][W];
			g=new int[H][W];
			tmpg=new int[H][W];
			a=new int[W];
			b=new int[N];
			minCnt=Integer.MAX_VALUE;
			
			for(int i=0; i<W; i++) {
				a[i]=i;
			}
			
			for(int i=0; i<H; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					g[i][j]=Integer.parseInt(st.nextToken());
					origin[i][j]=g[i][j];
				}
			}
			perm(0);
			sb.append("#").append(tc).append(" ").append(minCnt).append("\n");
		}
		System.out.println(sb);
	}
	static void perm(int cnt) {
		if(cnt==N) {
			copyOrigin();
			fallBall();
			return;
		}
		for(int i=0; i<W; i++) {
			b[cnt]=a[i];
			perm(cnt+1);
		}
	}
	static void fallBall() { // 구슬 떨어트리기
		for(int i=0; i<N; i++) { //전체 구슬 for문
			ArrayDeque<int[]> q = new ArrayDeque<>();
			int fallc = b[i];
			for(int fallr=0; fallr<H; fallr++) {
				int nowBlock = g[fallr][fallc];
				if(nowBlock > 0) { // 0이상(블록)을 만나면
					q.offer(new int[] {fallr,fallc,nowBlock}); // q에 넣어주고 break
					break;
				}
			}
			
			while(!q.isEmpty()) { // 구슬 떨구기 및 부시기
				int[] now=q.poll();
				int r=now[0];
				int c=now[1];
				int cnt=now[2];
				
				for(int k=0; k<cnt; k++) {
					for(int d=0; d<4; d++) {
						int nr=r+dr[d]*k;
						int nc=c+dc[d]*k;
						
						if(0<=nr&&nr<H && 0<=nc&&nc<W && g[nr][nc]>0) {
							q.offer(new int[] {nr,nc,g[nr][nc]});
							g[nr][nc]=0;
						}
					}
				}
				
			}// 끝
			moveBlock();
		}//for문 끝
		countBlock();
	}
	static void moveBlock() { // 빈공간으로 블록 떨어지게
		tmpg=new int[H][W];
		for(int j=0; j<W; j++) {
			int top=H-1;
			for(int i=H-1; i>=0; i--) {
				if(g[i][j]>0) {
					tmpg[top][j]=g[i][j];
					top--;
				}
			}
		}
		g=new int[H][W];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				g[i][j]=tmpg[i][j];
			}
		}
	}
	
	static void countBlock() { //블록 세기
		int cnt=0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(g[i][j]>0) cnt++;
			}
		}
		minCnt=Math.min(minCnt, cnt);
		
	}
	
	static void copyOrigin() {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				g[i][j]=origin[i][j];
			}
		}
	}
}