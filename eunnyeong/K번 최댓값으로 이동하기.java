import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {

  static int n;
  static int[][] a;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};

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
    st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    x--; y--;

    for (int i = 0; i < k; i++) {
      Point p = bfs(x, y);
      x = p.x; y = p.y;
    }

    System.out.print((x + 1) + " " + (y + 1));
  }

  public static Point bfs(int x, int y) {
    boolean[][] visit = new boolean[n][n];
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(x, y));
    visit[x][y] = true;

    Point ans = new Point(x, y);
    int max = 0;

    int tx = x, ty = y;
    while (!q.isEmpty()) {
      Point p = q.poll();
      if (a[p.x][p.y] != a[x][y] && max <= a[p.x][p.y]) {
        if (max == a[p.x][p.y]) {
          if (tx > p.x || (tx == p.x && ty > p.y)) {
            tx = p.x;
            ty = p.y;
          }
        }
        else {
          max = a[p.x][p.y];
          tx = p.x;
          ty = p.y;
        }
        
        ans = new Point(tx, ty);
      }
      for (int i = 0; i < 4; i++) {
        int nx = p.x + dx[i], ny = p.y + dy[i];
        if (range(nx, ny) && !visit[nx][ny] && a[nx][ny] < a[x][y]) {
          visit[nx][ny] = true;
          q.add(new Point(nx, ny));
        }
      }
    }

    return ans;
  }

  public static boolean range (int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < n) return true;
    return false;
  }
}
