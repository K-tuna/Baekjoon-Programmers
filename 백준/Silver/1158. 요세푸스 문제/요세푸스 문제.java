import java.io.*;
import java.util.*;

public class Main {
	static int N,K;
	static List<Integer> list = new ArrayList<Integer>();
	static List<Integer> answer = new ArrayList<Integer>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		for(int i=N-1; i>=0; i--) {
			Collections.rotate(list, -K+1);
			answer.add(list.get(0));
			list.remove(0);
		}
		
		sb.append("<");
		for(Integer a:answer) {
			sb.append(a).append(", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb);
	}
}