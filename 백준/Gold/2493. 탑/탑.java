import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayDeque<Integer[]> stack = new ArrayDeque<>();
	static int[] tower;
	static int[] answer;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		answer = new int[N];
		tower = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			tower[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			while(!stack.isEmpty()) {
				if(stack.peek()[1] > tower[i]) {
					sb.append(stack.peek()[0] + 1 + " "); 
					break;
				}else {
					stack.pop();					
				}
			}
			if(stack.isEmpty())
				sb.append(0+ " ");
			stack.push(new Integer[] {i, tower[i]});
		}
		System.out.println(sb);	
	}
}