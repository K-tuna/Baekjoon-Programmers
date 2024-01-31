import java.io.*;
import java.util.*;

public class Solution {
	static final int N = 100;
	static int[][] ladder;
	static int R,C;
	static int[] dr = { 0,0,-1}; // 좌 우 상
	static int[] dc = {-1,1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//입력
		for(int tc=1; tc<=10; tc++) {
			// ladder배열 초기화
			ladder = new int[N][N];
			//tc
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			//사다리 입력
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());			
				for(int j=0; j<N; j++) {
					int now = Integer.parseInt(st.nextToken());
					ladder[i][j] = now;
					if (now == 2) { // 출발지점이면
						R=i; // 출발지점 i랑
						C=j; // j를 저장 (좌표저장)
					}
				}
			}
			
			int answer = ladderUp();
			sb.append("#").append(num).append(" ").append(answer).append("\n"); // tc 출력
		}
		System.out.println(sb);
	}
	// 사다리 도착지점에서 거꾸로 올라가기 
	// 아래에 있는 도착 지점부터 출발하는게 포인트
	static int ladderUp() {
		int nr = R;
		int nc = C;
		ladder[nr][nc]=0;
		while(true) {
			for(int i=0; i<3; i++) {
				int tmpR = nr + dr[i];
				int tmpC = nc + dc[i];
				if(tmpC < 0 || tmpC >= N)
					continue;
				if(ladder[tmpR][tmpC]==0)
					continue;
				if(tmpR==0)
					return tmpC;
				else {
					ladder[tmpR][tmpC]=0;
					nr=tmpR;
					nc=tmpC;
					continue;
				}
			}		
		}	
	}
}