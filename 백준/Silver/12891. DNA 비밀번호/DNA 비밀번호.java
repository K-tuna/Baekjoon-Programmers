import java.io.*;
import java.util.*;

public class Main {
	static int S,P,answer=0;
	static int A,C,G,T;
	static String str;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// S P
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		// DNA 문자열
		st = new StringTokenizer(br.readLine());
		str = st.nextToken().toString();
		
		// 최소 개수 A C G T
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		window();
		
		sb.append(answer);
		System.out.println(sb);
	}
	// 슬라이딩 윈도우
	static void window() {
		// 초기값
		for (int i = 0; i < P; i++) {
			char now = str.charAt(i);
			if(now == 'A') A--;
			else if(now == 'C') C--;
			else if(now == 'G') G--;
			else if(now == 'T') T--;
		}
		if(A<=0 && C<=0 && G<=0 && T<=0) answer++;
		
		for (int i = 0; i < S-P; i++) {
			char start = str.charAt(i);
			if(start == 'A') A ++;
			else if(start == 'C') C++;
			else if(start == 'G') G++;
			else if(start == 'T') T++;
			
			char end = str.charAt(i+P);
			if(end == 'A') A--;
			else if(end == 'C') C--;
			else if(end == 'G') G--;
			else if(end == 'T') T--;
			if(A<=0 && C<=0 && G<=0 && T<=0) answer++;
		}
	}
}