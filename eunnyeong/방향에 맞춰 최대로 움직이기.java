import java.util.*;
import java.io.*;
public class Main {

  static int n, ans;
  static int[][] a, d;
  static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    d = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        d[i][j] = Integer.parseInt(st.nextToken());
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());

    ans = 0;
    bfs(x - 1, y - 1);
    System.out.print(ans);
  }

  public static void bfs(int x, int y) {
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(x, y, 0));

    while (!q.isEmpty()) {
      Point p = q.poll();
      ans = Math.max(ans, p.cnt);
      int idx = 1;
      while (true) {
        int t = d[p.x][p.y];
        int nx = p.x + dx[t] * idx, ny = p.y + dy[t] * idx;
        if (range(nx, ny)) {
          if (a[p.x][p.y] < a[nx][ny])
            q.add(new Point(nx, ny, p.cnt + 1));
          idx++;
        } else break;
      }
    }
  }

  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < n) return true;
    return false;
  }
  static class Point {
    int x, y, cnt;

    public  Point (int x, int y, int cnt) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
    }
  }
}
