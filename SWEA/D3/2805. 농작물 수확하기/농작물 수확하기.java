import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[][] farm = new String[N][N];
			int total = 0;
			for(int i=0; i<N; i++) {
				String[] memory = br.readLine().split("");
				farm[i]=memory;
			}
			int range = (N-1)/2;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(Math.abs(i-range)+Math.abs(j-range) <= (N-1)/2)
						total+=Integer.parseInt(farm[i][j]);
				}
			}
			
			
			sb.append("#").append(tc).append(" ").append(total).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}