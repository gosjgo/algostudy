import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

  static int n, h, m;
  static int[][] a, ans;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    ans = new int[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (a[i][j] == 2)
          bfs(i, j);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        System.out.print(ans[i][j] + " ");
      System.out.println();
    }
  }

  public static void bfs(int x, int y) {
    boolean[][] visit = new boolean[n][n];
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(x, y, 0));
    visit[x][y] = true;

    while (!q.isEmpty()) {
      Point p = q.poll();
      if (a[p.x][p.y] == 3) {
        ans[x][y] = p.d;
        return;
      }
      for (int i = 0; i < 4; i++) {
        int nx = p.x + dx[i], ny = p.y + dy[i];
        if (range(nx, ny) && !visit[nx][ny] && a[nx][ny] != 1) {
          q.add(new Point(nx, ny, p.d + 1));
          visit[nx][ny] = true;
        }
      }
    }

    ans[x][y] = -1;
  }

  public static boolean range (int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < n) return true;
    return false;
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
