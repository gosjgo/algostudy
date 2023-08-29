import java.util.*;
import java.io.*;

public class Main {

  static int n, k, ans;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0}, select;
  static List<Point> list;
  static Point s, e;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    int[][] a = new int[n][n];
    list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        a[i][j] = Integer.parseInt(st.nextToken());
        if (a[i][j] == 1)
          list.add(new Point(i, j, 0));
      }
    }

    st = new StringTokenizer(br.readLine());
    s = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);
    st = new StringTokenizer(br.readLine());
    e = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

    select = new int[k];
    ans = Integer.MAX_VALUE;
    comb(0, 0);

    if (ans == Integer.MAX_VALUE)
      ans = -1;

    System.out.print(ans);
  }

  public static void comb (int idx, int cnt) {
    if (cnt == k) {
      boolean[][] visit = new boolean[n][n];
      for (int i = 0; i < list.size(); i++) {
        Point x = list.get(i);
        visit[x.x][x.y] = true;
      }
      for (int i = 0; i < k; i++) {
        Point x = list.get(select[i]);
        visit[x.x][x.y] = false;
      }
      bfs(visit);
      return;
    }

    for (int i = idx; i < list.size(); i++) {
      select[cnt] = i;
      comb(i + 1, cnt + 1);
    }
  }

  public static void bfs(boolean[][] visit) {
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(s.x, s.y, s.d));
    visit[s.x][s.y] = true;

    while (!q.isEmpty()) {
      Point p = q.poll();
      if (p.x == e.x && p.y == e.y) {
        ans = Math.min(ans, p.d);
        return;
      }
      for (int i = 0; i < 4; i++) {
        int nx = p.x + dx[i], ny = p.y + dy[i];
        if (range(nx, ny) && !visit[nx][ny]) {
          q.add(new Point(nx, ny, p.d + 1));
          visit[nx][ny] = true;
        }
      }
    }
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
