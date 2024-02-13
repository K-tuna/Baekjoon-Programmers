import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		solve();
		System.out.println(sb);
	}
	static void solve() {
		int answer = -1;
		int cnt=0;
		while(N>=0) {
			if(N%5==0) {
				cnt+=N/5;
				sb.append(cnt);
				return;
			}
			N-=3;
			cnt+=1;
		}
		sb.append(answer);
		return;
	}
}