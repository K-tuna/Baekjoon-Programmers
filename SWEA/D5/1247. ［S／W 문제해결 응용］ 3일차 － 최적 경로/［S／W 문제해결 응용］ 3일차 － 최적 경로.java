import java.io.*;
import java.util.*;
public class Solution {
	static int N;
	static int[][] g; //
	static int[][] b; //
	static boolean[] v;
	static int startx,starty,endx,endy;
	static int ans=Integer.MAX_VALUE;
	static int tmp=0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			ans=Integer.MAX_VALUE;
			g=new int[N][2];
			b=new int[N][2];
			v=new boolean[N];
			st = new StringTokenizer(br.readLine());
			startx=Integer.parseInt(st.nextToken());
			starty=Integer.parseInt(st.nextToken());
			endx=Integer.parseInt(st.nextToken());
			endy=Integer.parseInt(st.nextToken());
			for(int i=0; i<N; i++) {
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				g[i][0]=x;
				g[i][1]=y;
			}
			perm(0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void perm(int cnt) {
		if(cnt==N) {
			ans=Math.min(ans, calc());
			return;
		}
		for(int i=0; i<N; i++) {
			if(v[i]) continue;
			v[i]=true;
			b[cnt][0]=g[i][0];
			b[cnt][1]=g[i][1];
			perm(cnt+1);
			v[i]=false;
		}
	}
	
	static int calc() {
		int sum=0;
		int dist = Math.abs(startx-b[0][0]) + Math.abs(starty-b[0][1]);
		sum+=dist;
		for(int i=1; i<N; i++) {
			dist = Math.abs(b[i-1][0]-b[i][0]) + Math.abs(b[i-1][1]-b[i][1]);
			sum+=dist;
			if(sum>ans) {
				return sum;
			}
		}
		dist = Math.abs(b[N-1][0]-endx) + Math.abs(b[N-1][1]-endy);
		sum+=dist;
		return sum;
	}
}