import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static boolean[] visited;
	static int[] a,b;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		//입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		a = new int[N+1];
		for(int i=1; i<=N; i++)
			a[i]=i;
		
		b = new int[M];
		perm(0);
	}
	//순열
	static public void perm(int cnt) {
		if(cnt==M) {
			for(int i=0; i<M; i++)
				System.out.print(b[i]+" ");
			System.out.println();
			return;
		}
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			b[cnt]=a[i];
			perm(cnt+1);
			visited[i]=false;
		}
	}
}