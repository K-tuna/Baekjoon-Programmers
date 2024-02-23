import java.io.*;
import java.util.*;

public class Main {
	static int N,d,k,c;
	static int[] v;
	static ArrayDeque<Integer> chobab;
	static ArrayDeque<Integer> eat;
	static int cnt;
	static int max;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		chobab=new ArrayDeque<>(); 
		eat=new ArrayDeque<>(); // 현재 먹는 조합
		v=new int[d+1];
		cnt=0;
		
		for(int i=0; i<N; i++) { // 전체 초밥 입력
			st = new StringTokenizer(br.readLine());
			chobab.offer(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0; i<k; i++) {
			int top = chobab.poll();
			eat.offer(top);
			if(v[top]==0) {
				cnt++;
			}
			v[top]++;
		}
		
		max=cnt;
		
		for(int i=0; i<N+k; i++) {
			int ctop = chobab.poll();
			eat.offer(ctop);
			int etop = eat.poll();
			chobab.offer(etop);
			
			if(v[ctop]==0) {
				cnt++;
			}
			v[ctop]++;
			if(--v[etop]==0) {
				cnt--;
			}
			
			if(v[c]==0) {
				max=Math.max(max, cnt+1);
			} else {
				max=Math.max(max, cnt);
			}
		}
		
		sb.append(max);
		
		
		
		System.out.println(sb);
		br.close();
	}
	
	
}