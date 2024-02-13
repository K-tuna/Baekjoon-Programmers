import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] small,isNotSmall;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		small = new int[9];
		isNotSmall = new int[2];
		int total = 0;
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			small[i]=Integer.parseInt(st.nextToken());
			total+=small[i];
		}
		int sum = total-100;
		
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum==small[i]+small[j]) {
					isNotSmall[0]=small[i];
					isNotSmall[1]=small[j];
				}
			}
		}
		for(int i=0; i<9; i++) {
			if(small[i]==isNotSmall[0] || small[i]==isNotSmall[1]) continue;
			sb.append(small[i]+"\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}