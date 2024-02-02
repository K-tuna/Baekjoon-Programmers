import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=1; i<=N; i++) {
			dq.add(i);
		}
		
		for(int i=0; i<N-1; i++) {
			dq.poll();
			dq.add(dq.poll());
		}
		
		System.out.println(dq.peek());
	}
}