import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static Queue<int[]> q=new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        
        int answer=0;
        int[] arr=new int[]{N,0};
        int[] sub;
        int a;
        q.offer(arr);
        while(!q.isEmpty()) {
        	sub=q.poll();
        	a=sub[0];
        	//System.out.println(a);
        	if(a==1) {
        		answer=sub[1];
        		break;
        	}
        	if(a%3==0) {
        		q.offer(new int[] {a/3,sub[1]+1});
        	}
        	if(a%2==0) {
        		q.offer(new int[] {a/2,sub[1]+1});
        	} 
        	q.offer(new int[] {a-1,sub[1]+1});
        }
        
        System.out.println(answer);
        
    }
}