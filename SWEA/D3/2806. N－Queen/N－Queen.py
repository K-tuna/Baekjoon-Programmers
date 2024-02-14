import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] row;
	static int ans;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			row=new int[N];
			ans=0;
			nQueen(0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static boolean is_promising(int n) {
		for(int i=0; i<n; i++) {
			if(row[n]==row[i] || Math.abs(row[n]-row[i])==Math.abs(n-i))
				return false;
		}
		return true;
	}
	
	static void nQueen(int n) {
		if (n==N){
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
	static void printArr() {
		for(int i=0; i<N; i++) {
			sb.append(row[i]+" ");
		}
		sb.append("\n");
	}
}