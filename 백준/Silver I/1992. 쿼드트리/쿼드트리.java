import java.io.*;
import java.util.*;

public class Main { 
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] strArr = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(strArr[j]);
			}
		}
		divide(0, 0, N);
		System.out.println(sb);
		br.close();
	}
	
	static void divide(int r, int c, int n) {
		if(check(r, c, n)) {
			sb.append(map[r][c]);
			return;
		}
		sb.append("(");
		
		int half = n/2;
		divide(r, c, half);
		divide(r, c+half, half);
		divide(r+half, c, half);
		divide(r+half, c+half, half);
		sb.append(")");
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