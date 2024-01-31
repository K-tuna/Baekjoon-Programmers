import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] a,b;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		//입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N+1];
		for(int i=1; i<=N; i++)
			a[i]=i;
		
		b = new int[M];
		comb(0,1);
	}
	//순열
	static public void comb(int cnt,int start) {
		if(cnt==M) {
			for(int i=0; i<M; i++)
				System.out.print(b[i]+" ");
			System.out.println();
			return;
		}
		for(int i=start; i<=N; i++) {
			b[cnt]=a[i];
			comb(cnt+1, i+1);
		}
	}
}