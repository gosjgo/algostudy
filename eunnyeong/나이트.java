import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

  static int n;
  static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2}, dy = {-1, -2, -2, -1, 1, 2, 2, 1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    Point s = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
    Point e = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

    System.out.print(bfs(s, e));
  }

  public static int bfs(Point s, Point e) {
    boolean[][] visit = new boolean[n + 1][n + 1];
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(s.x, s.y, 0));
    visit[s.x][s.y] = true;

    while (!q.isEmpty()) {
      Point p = q.poll();
      if (p.x == e.x && p.y == e.y)
        return p.d;
      for (int i = 0; i < 8; i++) {
        int nx = p.x + dx[i], ny = p.y + dy[i];
        if (range(nx, ny) && !visit[nx][ny]) {
          q.add(new Point(nx, ny, p.d + 1));
          visit[nx][ny] = true;
        }
      }
    }

   return -1;
  }

  public static boolean range (int nx, int ny) {
    if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) return true;
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
