import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc=1; tc<=10; tc++) {
			int answer;

			ArrayDeque<Character> stack = new ArrayDeque<>();
			// N 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken().toString();
			
			
			for(int i=0; i<N; i++) {
				char now = str.charAt(i);
				
				if(now ==')' && stack.peek()=='(') stack.pop();
				else if(now ==']' && stack.peek()=='[') stack.pop();
				else if(now =='}' && stack.peek()=='{') stack.pop();
				else if(now =='>' && stack.peek()=='<') stack.pop();
				else {
					stack.push(now);
				}
			}

			if(stack.isEmpty()) 
				answer=1;
			else
				answer=0;
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}