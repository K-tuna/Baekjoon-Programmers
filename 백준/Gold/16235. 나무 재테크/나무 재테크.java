import java.io.*;
import java.util.*;


public class Main {

	static int N, M, K;
	static int[][] add;
	static int[][] map;
	
	static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};
	static Queue<Tree> q;
	
	static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int age;
		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.age, o.age);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N]; 
		add = new int[N][N];
		q = new LinkedList<>();
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				add[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			q.add(new Tree(x-1, y-1, age));
		}
		
		
		// 한번 정렬 해놓으면 정렬 필요x 그래서 우선순위큐 안 써도됨
		Collections.sort((List<Tree>) q);
		
		for(int a=0; a<K; a++) {
			ArrayList<Tree> dead = new ArrayList<>();
			// 봄
			int q_len = q.size();
			
			while(q_len-- > 0) {
				Tree tree = q.poll();
				if(tree.age <= map[tree.x][tree.y]) {
					map[tree.x][tree.y] -= tree.age;
					q.add(new Tree(tree.x, tree.y, tree.age+1));
				} else {
					dead.add(new Tree(tree.x, tree.y, tree.age));
				}
			}
			
			// 여름
			for(Tree tree:dead) {
				map[tree.x][tree.y] += tree.age/2;
			}
			ArrayList<Tree> parent = new ArrayList<>();
			q_len = q.size();
			
			// 가을
			while(q_len-- > 0) {
				Tree tree = q.poll();
				parent.add(tree);
				if(tree.age % 5 == 0) { // 나이가 5의 배수
					for(int d=0; d<8; d++) {
						int nr = tree.x + dr[d];
						int nc = tree.y + dc[d];
						if(0<=nr&&nr<N && 0<=nc&&nc<N) { //범위 안이면
							q.add(new Tree(nr,nc,1));
						}
					}
				}
			}
			
			for(Tree tree:parent) {
				q.add(tree);
			}
			
			// 겨울
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] += add[i][j];
				}
			}
		}
		
		System.out.println(q.size());
		
	}
}