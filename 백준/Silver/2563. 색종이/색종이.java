import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map; //배열
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[100][100]; // 원본 배열
		int sum=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for(int x=r; x<r+10; x++) {
				for(int y=c; y<c+10; y++) {
					map[x][y]=1;
				}
			}
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]==1)
					sum++;
			}
		}
		sb.append(sum);
		System.out.println(sb);
	}
}