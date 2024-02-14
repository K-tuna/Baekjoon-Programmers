import java.io.*;
import java.util.*;

public class Main { //조합
	static int N,M,ChickenCnt;
	static int[][] map;
	static boolean[] visited;
	static List<int[]> house;
	static List<int[]> chicken;
	static List<Integer> chickenOpen;
	
	static int answer = Integer.MAX_VALUE;

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		chickenOpen = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					house.add(new int[] {i,j});
				else if(map[i][j]==2) {
					chicken.add(new int[] {i,j});
					ChickenCnt++;
				}
			}
		}
		visited = new boolean[ChickenCnt];
		comb(0,0);
		sb.append(answer);
		System.out.println(sb);
		br.close();
	}
	
	static void countDist() {
		int sum = 0;
		for(int i=0; i<house.size(); i++) {
			int [] nowHouse = house.get(i);
			int minDist = Integer.MAX_VALUE;
			for(int j=0; j<chickenOpen.size(); j++) {
				int[] nowChicken = chicken.get(chickenOpen.get(j));
				int dist = Math.abs(nowChicken[0] - nowHouse[0]) + Math.abs(nowChicken[1]-nowHouse[1]);
				minDist = Math.min(dist, minDist);
			}
			sum+=minDist;
		}
		answer = Math.min(answer, sum);
	}
	static void comb(int cnt, int start) { //
		if(cnt==M) {
			countDist();
			return;
		}
		for(int i=start; i<ChickenCnt; i++) {
			if(!visited[i]) {
				visited[i]=true;
				chickenOpen.add(i);
				comb(cnt+1,i+1);
				visited[i]=false;
				chickenOpen.remove(chickenOpen.size()-1);
			}
		}
	}
}