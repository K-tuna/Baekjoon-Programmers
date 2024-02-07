import java.io.*;
import java.util.*;

public class Main {
	static int N,M,R,ORDER;
	static int[][] map; //배열
	static int[][] tmp; //배열
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M]; // 원본 배열
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) {
			ORDER=Integer.parseInt(st.nextToken());
			switch (ORDER) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				swap();
				break;
			case 4:
				four();
				swap();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			default:
				break;
			}
			map = new int[N][M]; // 원본 배열
			copyArr();
		}
		printArr(N,M);
		System.out.println(sb);
	}
	static void swap() {
		int tmp=0;
		tmp=N;
		N=M;
		M=tmp;
	}
	static void copyArr() {
		for(int i=0; i<N; i++) { // 배열 출력
			for(int j=0; j<M; j++) {
				map[i][j]=tmp[i][j];
			}
		}
	}
	
	static void printArr(int n, int m) {
		for(int i=0; i<n; i++) { // 배열 출력
			for(int j=0; j<m; j++) {
				sb.append(tmp[i][j]+" ");
			}
			sb.append("\n");
		}
	}
	static void one() {
		tmp = new int[N][M]; // 바뀐 배열
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tmp[i][j]=map[N-i-1][j];
			}
		}	
	}
	static void two() {
		tmp = new int[N][M]; // 바뀐 배열
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tmp[i][j]=map[i][M-j-1];
			}
		}	
	}
	static void three() {
		tmp = new int[M][N]; // 바뀐 배열
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tmp[j][N-i-1]=map[i][j];
			}
		}	
	}
	static void four() {
		tmp = new int[M][N]; // 바뀐 배열
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tmp[M-j-1][i]=map[i][j];
			}
		}	
	}
	static void five() {
		tmp = new int[N][M]; // 바뀐 배열
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i<N/2) {
					if(j<M/2) { // 1
						tmp[i][j+M/2]=map[i][j];						
					}else { // 2
						tmp[i+N/2][j]=map[i][j];
					}
				}else {
					if(j<M/2) { // 4
						tmp[i-N/2][j]=map[i][j];	
					}else { // 3
						tmp[i][j-M/2]=map[i][j];
					}
				}
			}
		}	
	}
	static void six() {
		tmp = new int[N][M]; // 바뀐 배열
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i<N/2) {
					if(j<M/2) { // 1
						tmp[i+N/2][j]=map[i][j];						
					}else { // 2
						tmp[i][j-M/2]=map[i][j];
					}
				}else {
					if(j<M/2) { // 4
						tmp[i][j+M/2]=map[i][j];	
					}else { // 3
						tmp[i-N/2][j]=map[i][j];
					}
				}
			}
		}	
	}
}