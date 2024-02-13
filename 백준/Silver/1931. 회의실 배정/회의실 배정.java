import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Time[] times;
	static class Time implements Comparable<Time>{
		int start;
		int end;
		
		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			return this.end!=o.end ? 
					Integer.compare(this.end, o.end):
						Integer.compare(this.start,o.start);
		}
	}
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		times = new Time[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i]=new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(times);
		List<Time> list = new ArrayList<>();
		list.add(times[0]); //첫회의 선택
		for(int j=1; j<N; j++) {
			if(list.get(list.size()-1).end <= times[j].start) {
				list.add(times[j]);
			}
		}
		
		sb.append(list.size());
		
		System.out.println(sb);
		br.close();
	}
}