import java.io.*;
import java.util.*;

public class Main {
	static int L,C;
	static String[] a,b;
	static boolean[] v;
	
	static String[] mo = {"a","e","i","o","u"};
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		a=new String[C];
		b=new String[L];
		v=new boolean[C];
		for(int i=0; i<C; i++) {
			a[i] = st.nextToken();
		}
		Arrays.sort(a);
		
		comb(0,0);
		
		System.out.println(sb);
		br.close();
	}
	
	
	static void comb(int cnt, int start) {
		if(cnt==L) {
			if(isMoJa()) {
				printArr(b);
			}
			return;
		}
		for(int i=start; i<C; i++) {
			b[cnt]=a[i];
			comb(cnt+1, i+1);
		}
		
	}
	
	static boolean isMoJa() { // 모음이 한개 이상이고 자음이 두개 이상인지 확인
		int mo_cnt=0;
		int ja_cnt=0;
		List<String> list = new ArrayList<>(Arrays.asList(mo));
		for(int i=0; i<L; i++) {
			if(list.contains(b[i])) {
				mo_cnt++;
			}else {
				ja_cnt++;
			}
		}
		
		if(mo_cnt>=1 && ja_cnt>=2) {
			return true;
		}else {
			return false;
		}
	}
	
	static void printArr(String[] arr) {
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]);
		}
		sb.append("\n");
	}
}