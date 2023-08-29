import java.util.*;
import java.io.*;

public class Main {

  static int n, k;
  static int[][] a, ans;
  static int[] dx = {1, 0, 0, -1}, dy = {0, -1, 1, 0};
  static Point[] list;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    ans = new int[n][n];
    list = new Point[k];
    int idx = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        a[i][j] = Integer.parseInt(st.nextToken());
        if (a[i][j] == 2)
          list[idx++] = new Point(i, j, 0);
        if (a[i][j] == 0)
          ans[i][j] = -1;
      }
    }

    bfs();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        System.out.print(ans[i][j] + " ");
      System.out.println();
    }
  }

  public static void bfs() {
    boolean[][] visit = new boolean[n][n];
    Queue<Point> q = new ArrayDeque<>();

    for (int i = 0; i < k; i++) {
      Point p = list[i];
      q.add(p);
      visit[p.x][p.y] = true;
    }

    while (!q.isEmpty()) {
      Point p = q.poll();
      if (a[p.x][p.y] != 0) {
        for (int i = 0; i < 4; i++) {
          int nx = p.x + dx[i], ny = p.y + dy[i];
          if (range(nx, ny) && !visit[nx][ny] && ans[nx][ny] == 0) {
            q.add(new Point(nx, ny, p.d + 1));
            visit[nx][ny] = true;
            ans[nx][ny] = p.d + 1;
          }
        }
      }
    }

    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (a[i][j] == 1 && ans[i][j] == 0)
          ans[i][j] = -2;
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }

  static class Point {
    int x, y, d;

    public Point(int x, int y, int d) {
      this.x = x;
      this.y = y;
      this.d = d;
    }
  }
}
