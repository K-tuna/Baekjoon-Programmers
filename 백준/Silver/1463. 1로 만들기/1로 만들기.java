import java.util.*;
import java.io.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int max = (int)Math.pow(10, 6)+1;
		int[] dp = 	new int[max];
		
		for(int i=2; i<N+1; i++) {
			dp[i]=dp[i-1]+1;
			if(i%2==0)
				dp[i]=Math.min(dp[i], dp[i/2]+1);
			if(i%3==0)
				dp[i]=Math.min(dp[i], dp[i/3]+1);
		}
		System.out.println(dp[N]);
	}
}