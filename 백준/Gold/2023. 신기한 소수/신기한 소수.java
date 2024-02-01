import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] eratosthenes;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
//		eratosthenes = new boolean[(int)Math.pow(10, N+1)];
//		makeEratos();
		solve(1, 2);
		solve(1, 3);
		solve(1, 5);
		solve(1, 7);
		
		System.out.println(sb);
	}
	
	//에라토스테네스의 체
	static void makeEratos() {
		//true로 초기화
		for (int i = 2; i <= N; i++) {
			eratosthenes[i] = true;
		}
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if(eratosthenes[i]) {
				for (int j = i*i; j <= N; j += i) {
					eratosthenes[j] = false;
				}
			}
		}
	}
	// 소수 판별
	static boolean isPrime(int num) {
		for(int i=2; i<=num/2; i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	
	// 소수 구하기
	static public void solve(int cnt, int num) {
		if(!isPrime(num)) return;
		if(cnt==N) {
			sb.append(num).append("\n");
			return;
		}
		for(int i=1; i<=9; i++) {
			solve(cnt+1, num*10+i);
		}
	}
}