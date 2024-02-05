import java.io.*;
import java.util.*;

public class Main {
	static int N; // 숫자의 개수
	static long max,min;
	static int[] arr; // 숫자
	static int[] operator; //연산자의 개수
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer;
		max=Integer.MIN_VALUE;
		min=Integer.MAX_VALUE;
		// N 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		operator = new int[4];
		
        // 수식에 사용되는 숫자
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken()); 
		}
		// 연산자의 개수
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken()); 
		}
			
		
		dfs(1,arr[0]);

		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}
	
	static void dfs(int cnt, long sum) {
		
		if(cnt==N) {
			if(min>sum) min=sum;
			if(max<sum) max=sum;
			return;
		}
		for(int i=0; i<4; i++) {
			if(operator[i]!=0) {
				operator[i]--; //해당 연산자 개수 하나 감소
				if(i==0) dfs(cnt+1,sum+arr[cnt]);
				if(i==1) dfs(cnt+1,sum-arr[cnt]);
				if(i==2) dfs(cnt+1,sum*arr[cnt]);
				if(i==3) dfs(cnt+1,sum/arr[cnt]);
				operator[i]++;
			}
		}
	}
}