import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N,M,K;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map,tmp;
	static boolean[] v;
	static int[][] a;
	static int[][] b;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		a=new int[K][4];
		b=new int[K][4];
		v=new boolean[K];
		
		map = new int[N][M];
		tmp = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				tmp[i][j] = map[i][j];
			}
		}
		
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			a[k][0]= r-s-1;
			a[k][1]= c-s-1;
			a[k][2]= r+s-1;
			a[k][3]= c+s-1;
		}
//		for (int i = 0; i < K; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(a[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		perm(0);

		
		
		sb.append(min);
		
		System.out.println(sb);
		br.close();
	}
	static void perm(int cnt) {
		if(cnt==K) {
//			for (int i = 0; i < K; i++) {
//				for (int j = 0; j < 4; j++) {
//					sb.append(b[i][j]+" ");
//				}
//				sb.append("\n");
//			}
//			sb.append("\n");
			turnArr();
			return;
		}
		for(int i=0; i<K; i++) {
			if(v[i]) continue;//
			v[i]=true;//
			b[cnt]=a[i];
			perm(cnt+1);
			v[i]=false;//
		}
	}
	static void turnArr() {
		loadArr();
		for(int t=0;t<K;t++) {
			int r1= b[t][0];
			int r2= b[t][2];
			int c1= b[t][1];
			int c2= b[t][3];
//			sb.append("r1,r2,c1,c2 "+r1+" "+r2+" "+c1+" "+c2+"\n");
//			printArr();
			int round = Math.min(r2-r1+1, c2-c1+1)/2;
			for(int i=r1,j=c1,idx=0;i<r1+round||j<c1+round;i++,j++,idx++) {
				int cnt = 0;
				int now = map[i][j];
				int x = i, y = j;
				while(cnt<4) {
					int nx = x +dx[cnt];
					int ny = y +dy[cnt];
					
					if(nx>=i && ny>=j && nx<r2-idx+1 && ny<c2-idx+1) {
						map[x][y] = map[nx][ny];
						x = nx;
						y = ny;
//						printArr();
					}
					else {
						cnt++;
					}
				}
				map[i][j+1] = now;
//				printArr();
			}
//			sb.append("1개 연산 끝\n\n");
		}
		sum();
//		sb.append("k개 연산 끝\n\n");
	}
	static void sum() {
		for(int i=0; i<N; i++) {
			int total = 0;
			for(int j=0; j<M; j++) {
				total+=map[i][j];
			}
//			sb.append("sum: "+total+"\n");
			if (min>total) {
				min=total;
			}
		}
	}
	static void loadArr() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=tmp[i][j];
			}
		}
	}
	static void printArr() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		sb.append("\n");
	}
}