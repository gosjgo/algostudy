import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {

  static int n, k, u, d, max;
  static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
  static int[][] a;
  static Point[] num, select;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    u = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    num = new Point[n * n];
    int idx = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        a[i][j] = Integer.parseInt(st.nextToken());
        num[idx++] = new Point(i, j);
      }
    }

    select = new Point[k];
    max = 0;
    comb(0, 0);

    System.out.print(max);
  }

  public static void bfs() {
    boolean[][] visit = new boolean[n][n];
    Queue<Point> q = new ArrayDeque<>();
    int[][] ans = new int[n][n];

    for (int i = 0; i < k; i++) {
      Point p = select[i];
      q.add(new Point(p));
      visit[p.x][p.y] = true;
      ans[p.x][p.y] = 1;
    }

    while (!q.isEmpty()) {
      Point p = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = p.x + dx[i], ny = p.y + dy[i];
        if (range(nx, ny)) {
          int diff = Math.abs(a[p.x][p.y] - a[nx][ny]);
          if (!visit[nx][ny] && diff >= u && diff <= d) {
            visit[nx][ny] = true;
            ans[nx][ny] = 1;
            q.add(new Point(nx, ny));
          }
        }
      }
    }

    int sum = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (ans[i][j] == 1)
          sum++;

    max = Math.max(max, sum);
  }

  public static void comb(int cnt, int idx) {
    if (cnt == k) {
      bfs();
      return;
    }

    for (int i = idx; i < n * n; i++) {
      select[cnt] = num[i];
      comb(cnt + 1, i + 1);
    }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }
}
