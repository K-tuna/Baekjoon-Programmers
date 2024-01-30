import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[][] visited = new boolean[101][101];
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,-1,0,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		
		// 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragoncurve(x, y, d, g);
		}
		br.close();
		sb.append(findSquare());
		System.out.println(sb);
	}
	
	// 드래곤커브
	public static void dragoncurve(int x, int y, int d, int g) {
		List<Integer> arr = new ArrayList<>();
		arr.add(d);
		// 세대 수 g만큼 for문 돌려서 리스트에 방향 추가
		for(int i=1; i<=g; i++) {
			for(int j=arr.size()-1; j>=0; j--) {
				arr.add((arr.get(j)+1)%4);
			}
		}
		visited[y][x] = true;
		// 방향기반으로 xy값 변경
		for(Integer a:arr) {
			x += dr[a];
			y += dc[a];
			visited[y][x] = true;//방문배열 true로 바꿔줌
		}
	}
	// 사각형 찾기
	public static int findSquare() {
		int result = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(visited[i][j] && visited[i][j+1] && visited[i+1][j] && visited[i+1][j+1]) {
					result++;
				}
			}
		}
		return result;
	}
}