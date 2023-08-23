import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {

  static int n, ans;
  static int[][] a;
  static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
  static boolean[][] visit;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    ans = 0;
    visit = new boolean[n][n];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      bfs(x - 1, y - 1);
    }

    System.out.print(ans);
  }

  public static void bfs(int x, int y) {
   Queue<Point> q = new ArrayDeque<>();
   q.add(new Point(x, y));

   if (!visit[x][y])
     ans++;
   visit[x][y] = true;

   while (!q.isEmpty()) {
     Point p = q.poll();
     for (int i = 0; i < 4; i++) {
       int nx = p.x + dx[i], ny = p.y + dy[i];
       if (range(nx, ny) && !visit[nx][ny] && a[nx][ny] == 0) {
         ans++;
         visit[nx][ny] = true;
         q.add(new Point(nx, ny));
       }
     }
   }
  }

  public static boolean range (int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < n) return true;
    return false;
  }
}
