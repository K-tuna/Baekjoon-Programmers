import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[] v;
	static int min;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		v = new boolean[N];
		min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,0,1);
		
		System.out.println(min);
		
	}
	
	static void dfs(int i, int cost, int first, int cnt) {
		v[i]=true;
		if (cnt==N) {
			if (map[i][first]!=0) {
				min = Math.min(min, cost+map[i][first]);
			}
		}
		
		for(int j=0; j<N; j++) {
			if(map[i][j]!=0 && !v[j]) {
				dfs(j,cost+map[i][j],first,cnt+1);
			}
		}
		v[i]=false;
	}
}