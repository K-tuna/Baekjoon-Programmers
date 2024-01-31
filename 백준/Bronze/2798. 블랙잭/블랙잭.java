import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] arr;
	static int[] tmp;
	static int answer=0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N,M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// arr 초기화
		arr = new int[N];
		tmp = new int[3];
		
		// N개의 수 입력
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		comb(0,0);
		sb.append(answer);
		System.out.println(sb);
	}
	
	static void comb(int cnt, int start) {
		if(cnt==3) {
			int sum = 0;
			for(int n:tmp) {
				sum += n;
			}
			int max = Math.max(answer, sum);
			if(max>M)
				return;
			answer=max;
			return;
		}
		for(int i=start; i<N; i++) {
			tmp[cnt]=arr[i];
			comb(cnt+1, i+1);
		}
	}
}