import java.io.*;
import java.util.*;

public class Main {
	static int N,S;
	static int[] arr;
	static int ans=0;

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		backtracking(0, 0);
		if(S==0)
			ans--;
		sb.append(ans);
		System.out.println(sb);
		br.close();
	}
	
	static void backtracking(int cnt, int sum) {
		if(cnt==N) {
			if(sum==S) {
				ans++;
			}
			return;
		}
		backtracking(cnt+1, sum+arr[cnt]);
		backtracking(cnt+1, sum);
	}
}