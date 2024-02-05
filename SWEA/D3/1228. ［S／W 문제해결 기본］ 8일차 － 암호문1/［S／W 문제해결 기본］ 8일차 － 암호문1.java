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
			
			// 2.원본 암호문 List
			st = new StringTokenizer(br.readLine());
			List<Integer> password = new ArrayList<>();
			for(int i=0; i<N; i++) {
				password.add(Integer.parseInt(st.nextToken()));
			}
			
			// 3.명령어의 개수 commendNum
			st = new StringTokenizer(br.readLine());
			int commendNum = Integer.parseInt(st.nextToken());
			
			// 4.명령어
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < commendNum; i++) {
				String I = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				// tmp 리스트
				List<Integer> tmp = new ArrayList<>();
				for(int j=0; j<y; j++) {
					int s = Integer.parseInt(st.nextToken());
					tmp.add(s);
				}
				password.addAll(x,tmp);
			}
			sb.append("#").append(tc).append(" ");
			
			// 처음 10개 항 출력
			for(int i=0; i<10; i++) {
				sb.append(password.get(i)).append(" ");
			}
			
			sb.append("\n");
			
		}

		System.out.println(sb);
	}
	
}