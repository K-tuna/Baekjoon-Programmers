import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] row;
	static int ans=0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		row = new int[N];
		nQueen(0);
		sb.append(ans);
		System.out.println(sb);
		br.close();
	}
	
	static boolean is_promising(int n) {
		for(int i=0; i<n; i++) {
			if(row[n]==row[i] || Math.abs(row[n]-row[i])==Math.abs(n-i)) // 같은 열이거나, 대각선에 위치하거나
				return false;
		}
		return true;
	}
	
	static void nQueen(int n) {
		if(n==N) {
			ans++;
			return;
		}else {
			for(int i=0; i<N; i++) {
				row[n]=i;
				if(is_promising(n))
					nQueen(n+1);
			}
		}
	}
}