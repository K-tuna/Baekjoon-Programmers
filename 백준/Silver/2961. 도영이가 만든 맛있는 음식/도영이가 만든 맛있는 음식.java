import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long S,B,answer=Long.MAX_VALUE;
	static long[][] arr;
	static boolean[] v;
	static boolean[] zero;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new long[N][2];
		v = new boolean[N];
		zero = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr[i][0]=S;
			arr[i][1]=B;
		}
		subs(0,1,0);
		
		sb.append(answer);
		System.out.println(sb);
	}
	
	static void subs(int cnt, long multi, long sum) {
		if(cnt==N) {
			long gap = (multi - sum)>=0 ? multi-sum:(-1)*(multi-sum);
			if(answer>gap && !Arrays.equals(zero, v)) {
				answer=gap;
			}
			return;
		}
		v[cnt]=true;
		subs(cnt+1, multi*arr[cnt][0], sum+arr[cnt][1]);
		v[cnt]=false;
		subs(cnt+1, multi, sum);
	}
}