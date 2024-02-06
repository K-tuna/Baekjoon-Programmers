import java.io.*;
import java.util.*;

public class Solution {
	static int N; // 숫자의 개수
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc=1; tc<=10; tc++) {
			// 1.원본 암호문 길이 N 
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int result=1;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int cnt = st.countTokens();
				String point = st.nextToken();
				int num = st.nextToken().charAt(0)-'0';
				if(cnt==4 && num>=0 && num<=9) {
					result=0;
				} else if(cnt==2 && (num<0 || num>9)) {
					result=0;
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}