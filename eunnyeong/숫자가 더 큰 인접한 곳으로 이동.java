import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

  static int n;
  static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
  static int[][] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    bfs(r - 1, c - 1);
  }

  public static void bfs(int r, int c) {
    List<Integer> list = new ArrayList<>();
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(r, c));

    while (!q.isEmpty()) {
      Point p = q.poll();
      list.add(a[p.x][p.y]);
      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && a[nx][ny] > a[p.x][p.y]) {
          q.add(new Point(nx, ny));
          break;
        }
      }
    }

    for (Integer l: list)
      System.out.print(l + " ");
  }

  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < n) return true;
    return false;
  }
}
