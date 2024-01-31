import java.io.*;
import java.util.*;

public class Main {
	static int N,R;
	static int[] a,b;
	static StringBuilder sb = new StringBuilder();
	
	//조합
	static public void comb(int cnt,int start) {
		if(cnt==R) {
			for(int i=0; i<R; i++)
				sb.append(b[i]).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=start; i<=N; i++) {
			b[cnt]=a[i];
			comb(cnt+1, i);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		a = new int[N+1];
		for(int i=1; i<=N; i++)
			a[i]=i;
		
		b = new int[R];
		comb(0,1);
		System.out.println(sb);
	}
}