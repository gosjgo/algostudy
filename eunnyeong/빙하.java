import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {

  static int n, m, s;
  static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
  static int[][] a;
  static boolean[][] visit;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n][m];

    s = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }


    int ans = 0;
    ex:for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == 0) {
          bfs(i, j);
          ans++;
        }
        if (check()) break ex;
      }
    }

    System.out.println(ans + " " + s);
  }

  public static void bfs(int x, int y) {
    boolean[][] visit = new boolean[n][m];
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(x, y));
    visit[x][y] = true;

    int[][] t = new int[n][m]; // 얼음표시
    while (!q.isEmpty()) {
      Point p = q.poll();

      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny]) {
          visit[nx][ny] = true;
          if (a[nx][ny] == 0)
            q.add(new Point(nx, ny));
          else
            t[nx][ny] = 1;
        }
      }
    }

    int cnt = 0;
    for (int i = 0; i < n; i++) {//빙하 제거
      for (int j = 0; j < m; j++) {
        if (t[i][j] == 1) {
          a[i][j] = 0;
          cnt++;
        }
      }
    }
    if (cnt != 0)
      s = cnt;
  }

  public static boolean check() {
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (a[i][j] != 0)
          return false;

    return true;
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < m;
  }
}
