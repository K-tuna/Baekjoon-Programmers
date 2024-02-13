import java.io.*;
import java.util.*;

public class Main {
	static int N,L;

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		ArrayDeque<Integer> fruit = new ArrayDeque<>(list);

		while(!fruit.isEmpty()) {
			int now = fruit.poll();
			if(now<=L)
				L++;
			else
				break;
		}
		sb.append(L);
		
		System.out.println(sb);
		br.close();
	}
}