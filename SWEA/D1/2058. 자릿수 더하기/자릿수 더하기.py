import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int ans = 0;
			
		String str = st.nextToken();
		char[] arr = str.toCharArray();
		
		for(int i = 0; i<arr.length;i++) {
			ans+=Character.getNumericValue(arr[i]);
		}
			
			
		sb.append(ans);
		System.out.println(sb.toString());
		
		br.close();
	}
}