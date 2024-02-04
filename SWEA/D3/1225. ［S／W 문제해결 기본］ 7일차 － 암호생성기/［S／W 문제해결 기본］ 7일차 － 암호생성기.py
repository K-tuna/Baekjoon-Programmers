import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static ArrayDeque<Integer> q; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			q = new ArrayDeque<Integer>(); 
			
			// 8자리 숫자 입력
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<8; i++) {
				q.offer(Integer.parseInt(st.nextToken())); 
			}
			
			makePassWord();
			
			sb.append("#").append(T).append(" ");
			for(int i: q) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void makePassWord() {
		while(true) {
			for(int i=1; i<=5; i++) {
				int top = q.poll()-i;
				if(top <= 0) {
					top=0;
					q.offer(top);
					return;
				}
				q.offer(top);
			}
		}
	}
}