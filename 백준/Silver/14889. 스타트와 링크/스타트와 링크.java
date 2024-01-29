import java.io.*;
import java.util.*;

public class Main {
	static int answer = Integer.MAX_VALUE;
	static int N;
	static int[][] ability;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i]=i+1;
		}
		ability = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				ability[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		// 조합써야함
		combination(visited, 0, N, N/2);
		
		sb.append(answer);
		System.out.println(sb);
		br.close();
	}
	static void combination(boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			answer = Math.min(answer, combination2( visited));
			return ;
		}
			
		for(int i = start; i < n; i++) {
			visited[i] = true;
			combination(visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}
	static int combination2(boolean[] visited) {
		int first = 0;
		int second = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i]&&visited[j]) {
					first += ability[i][j];
				} else if (!visited[i] && !visited[j]) {
					second += ability[i][j];
				}
			}
		}
		return Math.abs(first-second);
	}
}