import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] edgeCount = new int[N+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            graph.get(Integer.parseInt(temp[0])).add(Integer.parseInt(temp[1]));
            edgeCount[Integer.parseInt(temp[1])]++;
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();

        // 진입차수가 0인 값 큐에 넣기
        for (int i = 1; i < edgeCount.length; i++) {
            if (edgeCount[i] == 0) {
                q.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            // 큐에서 학생번호 꺼내기
            int studentNo = q.poll();

            // 꺼낸 학생번호 출력값에 저장
            sb.append(studentNo+" ");

            // 꺼낸 학생번호의 키 비교한 정보 가져오기
            List<Integer> list = graph.get(studentNo);

            // 키를 비교한 정보의 개수 만큼 반복문 실행
            for (int i = 0; i < list.size(); i++) {
                // 해당 학생보다 뒤에 서야하는 학생의 정보 가져오기
                int temp = list.get(i);
                // 뒤에 서야하는 학생의 진입차수 감소
                edgeCount[temp] -- ;
                // 감소한 진입차수가 0이면 큐에 학생번호 넣기
                if (edgeCount[temp] == 0) {
                    q.offer(temp);
                }
            }
        }
		
		System.out.println(sb);
		br.close();
	}
}