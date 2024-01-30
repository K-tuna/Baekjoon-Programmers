import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] light;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		//입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		light = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			light[i]=Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int studentNum = Integer.parseInt(st.nextToken());
//		for(int j=1; j<N+1; j++)
//			System.out.print(light[j]+" ");
//		System.out.println();
		
		//학생 성별과 받은 수 입력과 동시에 스위치 바꾸는 함수 실행
		for(int i=0; i<studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());			
			int num = Integer.parseInt(st.nextToken());	
			
			if (gender == 1) {
				boyChange(num);
			}else {
				girlChange(num);
			}
		}
		// 20개씩 출력
		for(int i=1; i<N+1; i++) {
			System.out.print(light[i]);
			if (i%20==0)
				System.out.println();
			else if(i==N)
				break;
			else
				System.out.print(" ");
		}
		
	}
	
	public static void boyChange(int num) {
		for(int i=1; i<N+1; i++) {
			if(i%num==0)
				changeSwith(i);
		}
	}
	public static void girlChange(int num) {
		changeSwith(num);
		for(int i=1; i<N+1; i++) {
			if(num-i < 1 || num+i >= N+1 || light[num-i] != light[num+i]) break;
			changeSwith(num+i);
			changeSwith(num-i);
		}
	}
	public static void changeSwith(int i) {
		light[i]++;
		light[i]%=2;
	}
}