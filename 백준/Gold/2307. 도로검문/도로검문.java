import java.io.*;
import java.util.*;

public class Main {

	static class Data{
		int to;
		int time;

		public Data(int to, int time) {
			super();
			this.to = to;
			this.time = time;
			
		}
		@Override
		public String toString() {
			return "Data [to=" + to + ", time=" + time + "]";
		}
		
	}
	static int V,N,sa,sb;
	static List<Data>[] list;
	static int[] dist,p;
	static int[][] idx;
	static void dijkstra(int start) {
		//boolean[] v = new boolean[V+1];
		dist = new int[V+1];
		p = new int[V+1];
		for(int i=1; i<V+1;i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Data> pq = new PriorityQueue<>((o1,o2)->o1.time - o2.time);
		pq.add(new Data(start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Data temp = pq.poll();
			int from = temp.to;
			int time = temp.time;

			if(time > dist[from]) continue;
			
			for(Data d : list[from]) {
				if(sa==from && sb==d.to) continue;
				if(dist[d.to]>time+d.time) {
					dist[d.to] = time + d.time;
					p[d.to] = from;
					pq.offer(new Data(d.to,dist[d.to]));
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		list = new List[V+1];
		idx = new int[N][2];
		for(int i=0; i<V+1; i++) {
			list[i] = new ArrayList();
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Data(b,w));
			list[b].add(new Data(a,w));
		}
		
		
		//System.out.println(Arrays.toString(dist));
		
		//범인이 지나가는 도로만 지우기!
		int max = Integer.MIN_VALUE;

		
		dijkstra(1);
		int ans = dist[V];
		
		ArrayList<Integer> li = new ArrayList<>();
		int idx = V;
		while(1 != idx) {
			li.add(idx);
			idx = p[idx];
		}
		li.add(1);
		//System.out.println(li);
		
		int max2 = Integer.MIN_VALUE;
		for(int i=li.size()-1; i>0; i--) {
			sa = li.get(i);
			sb = li.get(i-1);
			//System.out.println(sa+" "+sb);
			dijkstra(1);
			//System.out.println(dist[V]);
			max = Math.max(max,dist[V]);
			
		}
			
		int result = -1;
		if(max!=Integer.MAX_VALUE) {
			result = max-ans;
		}
//		System.out.println(max2);
//		System.out.println(max);
		System.out.println(result);
		//for(List<Data> a : list) System.out.println(a);
		
	}

}