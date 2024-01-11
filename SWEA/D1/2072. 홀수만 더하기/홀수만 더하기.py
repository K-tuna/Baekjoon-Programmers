import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int count = st.countTokens();
			int ans = 0;
			
			//작성하세요 Integer.parseInt(st.nextToken());
			
			for (int i=0; i<count; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (num%2 == 1) {
					ans += num;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}
