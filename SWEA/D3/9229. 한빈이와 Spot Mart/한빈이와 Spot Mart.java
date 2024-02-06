import java.io.*;
import java.util.*;

public class Solution {
	static int N,M,T;
	static int answer;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	static void comb(int cnt, int start, int sum) {
		if(sum>M)
			return;
		if(cnt==2) {
			if(answer<sum)
				answer=sum;
			return;
		}
		
		for(int i=start; i<N; i++) {
			comb(cnt+1, i+1 , sum+arr[i]);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// T
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			// N M
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			
			// arr
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			answer=-1;
			comb(0,0,0);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}