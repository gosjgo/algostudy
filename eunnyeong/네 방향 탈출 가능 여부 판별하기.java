import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {

  static int n, m, ans;
  static int[][] a;
  static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    ans = 0;
    bfs();
    System.out.print(ans);
  }

  public static void bfs() {
   boolean[][] visit = new boolean[n][m];
   Queue<Point> q = new ArrayDeque<>();
   q.add(new Point(0, 0));
   visit[0][0] = true;

   while (!q.isEmpty()) {
     Point p = q.poll();
     if (p.x == n - 1 && p.y == m - 1)
       ans = 1;
     for (int i = 0; i < 4; i++) {
       int nx = p.x + dx[i], ny = p.y + dy[i];
       if (range(nx, ny) && !visit[nx][ny] && a[nx][ny] == 1) {
         visit[nx][ny] = true;
         q.add(new Point(nx, ny));
       }
     }
   }
  }

  public static boolean range (int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < m) return true;
    return false;
  }
}
