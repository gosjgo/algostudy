import java.util.Scanner;
import java.util.ArrayList;

public class DFS그래프탐색 {

    public static final int MAX_NUM = 1000;
    public static int n,m;

    // index를 1번부터 사용하기 위해 MAX_NUM+1 만큼 할당합니다.
    public static int[][] graph = new int[MAX_NUM+1][MAX_NUM+1];
    public static boolean[] visited = new boolean[MAX_NUM+1];
    public static int vertexCnt = 0;

    public static void DFS(int vertex){
        for(int currV=1;currV <= n;currV++){
            if(graph[vertex][currV] == 1 && !visited[currV]) {
                visited[currV] = true;
                vertexCnt++;
                DFS(currV);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[] start = new int[m];
        int[] end = new int[m];

        for(int i=0;i<m;i++){
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();

            graph[start[i]][end[i]]=1;
            graph[end[i]][start[i]]=1;
        }

        visited[1] = true;
        DFS(1);

        System.out.println(vertexCnt);

    }

}
