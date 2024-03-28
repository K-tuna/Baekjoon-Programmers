import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[][] map=new int[9][9];
	static boolean end;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			String str = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		
		dfs(0);
		printarr();
		System.out.println(sb);
	}
	
	static void dfs(int cnt) {
		if(cnt == 81) {
			end = true;
			return;
		}
		
		int r = cnt/9;
		int c = cnt%9;
		
		if(map[r][c] != 0) {
			dfs(cnt+1);
		}else {
			for(int i=1; i<=9; i++) {
				if(!check(r, c, i)) continue;
				map[r][c] = i;
				dfs(cnt + 1);
				if(end) return;
				map[r][c] = 0;
			}
		}
		
	}
	
	static boolean check(int r, int c, int n) {
		for(int i=0; i<9; i++) {
			if(map[r][i] == n || map[i][c] == n)
				return false;
		}
		
		int sR = r/3*3;
		int sC = c/3*3;
		
		for(int i=sR; i < sR+3; i++) {
			for(int j=sC; j < sC+3; j++) {
				if(map[i][j] == n)
					return false;
			}
		}
		
		return true;
	}
	
	static void printarr() {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
	}
}