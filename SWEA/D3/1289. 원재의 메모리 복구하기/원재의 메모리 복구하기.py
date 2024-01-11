import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] memory = br.readLine().split("");
			int count = memory.length;
			int ans = 0;
			String now = "0";
			//작성하세요 Integer.parseInt(st.nextToken());
			
			for(String n : memory) {
				if (!n.equals(now)) {
					ans += 1;
					now = n;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}