import java.io.*;
import java.util.*;

public class Solution {
	static int n,m;
	static int[] parents;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			parents = new int[n+1];
			make();
			
			sb.append("#").append(tc).append(" ");
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(k==0) {
					union(a,b);
				} else if(k==1) {
					if(find(a)==find(b))
						sb.append(1);
					else 
						sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void make() {
		for(int i=0; i<n+1; i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(a==parents[a])
			return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)
			return false;
		
		parents[bRoot]=aRoot;
		return true;
	}
}