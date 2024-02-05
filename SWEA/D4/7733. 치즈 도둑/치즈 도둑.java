import java.io.*;
import java.util.*;
 
public class Solution {
    static int N;
    static int[][] graph;
    static int ans;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
             
            ans = Integer.MIN_VALUE;
             
            N = Integer.parseInt(st.nextToken());
            graph = new int[N][N];
             
            int save = 0;
             
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0;j<N;j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                     
                }
            }
             
            int count;
            for(int k = 0; k<=100; k++) {
                count = 0;
                visited = new boolean[N][N];
                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                        if (graph[i][j]>k && visited[i][j]==false) {
                            bfs(i,j,k);
                            count ++;
                        }
                    }
                }
                if (count > ans) {
                    ans = count;
                    save = k;
                }
            }
             
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
         
        System.out.println(sb.toString());
         
        br.close();
    }
     
    public static void bfs(int x, int y, int day) {
         
        Queue<int[]> queue = new LinkedList<>();
         
        queue.add(new int[] {x,y});
        visited[x][y] = true;
         
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N && graph[nx][ny]>day && !visited[nx][ny]) {
                    queue.add(new int[] {nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
         
    }
}