import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

  static int n, m, ans;
  static int[][] a;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0}, select;
  static List<Point> list;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    list = new ArrayList<>();
    boolean[][] visit = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        a[i][j] = Integer.parseInt(st.nextToken());
        if (a[i][j] == 1) {
          list.add(new Point(i, j));
          visit[i][j] = true;
        }
      }
    }

    ans = 0;
    select = new int[m];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      comb(0, 0, x - 1, y - 1);
    }

    System.out.print(ans);
  }

  public static void comb (int cnt, int idx, int x, int y) {
    if (cnt == m) {
      boolean[][] visit = new boolean[n][n];
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          if (a[i][j] == 1)
            visit[i][j] = true;

      for (int i = 0; i < m; i++) {
        Point p = list.get(select[i]);
        visit[p.x][p.y] = false;
      }
      bfs(x, y, visit);
      return;
    }

    for (int i = idx; i < list.size(); i++) {
      select[cnt] = i;
      comb(cnt + 1, i + 1, x, y);
    }
  }

  public static void bfs(int x, int y, boolean[][] visit) {
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(x, y));
    visit[x][y] = true;

    int cnt = 0;
    while (!q.isEmpty()) {
      Point p = q.poll();
      cnt++;
      for (int i = 0; i < 4; i++) {
        int nx = p.x + dx[i], ny = p.y + dy[i];
        if (range(nx, ny) && !visit[nx][ny]) {
          q.add(new Point(nx, ny));
          visit[nx][ny] = true;
        }
      }
    }

    if (cnt > ans)
      ans = cnt;
  }

  public static boolean range (int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < n) return true;
    return false;
  }
}
