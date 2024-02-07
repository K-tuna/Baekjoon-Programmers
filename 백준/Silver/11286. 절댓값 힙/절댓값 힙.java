import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Math.abs(o1)==Math.abs(o2)? Integer.compare(o1, o2):Integer.compare(Math.abs(o1), Math.abs(o2)));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			if(x!=0) {
				pq.offer(x);
			}else {
				if(pq.isEmpty()){
					sb.append(0).append("\n");
				}else {
					sb.append(pq.poll()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}