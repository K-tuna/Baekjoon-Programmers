import java.io.*;
import java.util.*;

public class Main { //조합
	static int N;
	static int[][] map;
	static int white,blue;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		white=0;
		blue=0;
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		divide(0, 0, N);
		sb.append(white).append("\n").append(blue);
		System.out.println(sb);
		br.close();
	}
	
	static void divide(int r, int c, int n) {
		if(check(r, c, n)) {
			int color = map[r][c];
			if(color==1) {
				blue++;
			}else {
				white++;
			}
			return;
		}
		
		int half = n/2;
		divide(r, c, half);
		divide(r, c+half, half);
		divide(r+half, c, half);
		divide(r+half, c+half, half);
	}
	
	static boolean check(int r, int c, int n) {
		int color = map[r][c];
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++) {
				if(color != map[i][j])
					return false;
			}
		}
		return true;
	}
}