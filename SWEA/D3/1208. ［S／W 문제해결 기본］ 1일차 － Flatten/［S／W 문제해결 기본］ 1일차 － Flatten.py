import java.io.*;
import java.util.*;

public class Solution {
	static final int box_length = 100;
	static int[] box;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		//입력
		for(int tc=1; tc<=10; tc++) {
			//정답
			int answer=102;
			//덤프 횟수 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			//박스 입력
			box = new int[box_length];
			st = new StringTokenizer(br.readLine());			
			for(int i=0; i<box_length; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			
			//덤프 횟수만큼 덤프 실행
			for(int i=0; i<num+1; i++) {
				int diff = dump();
				answer=diff;
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static int dump() {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int maxIdx = 0;
		int minIdx = 0;
		for(int i=0; i<box_length; i++) {
			if (max < box[i]) {
				max=box[i];
				maxIdx=i;
			}
			if(min > box[i]) {
				min=box[i];
				minIdx=i;
			}
		}
		box[maxIdx]--;
		box[minIdx]++;
		
		return max-min;
	}
}