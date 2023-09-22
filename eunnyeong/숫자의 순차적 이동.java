import java.util.*;
import java.io.*;

public class Main {

  static int n;
  static int[] dx = {1, 0, 0, -1, 1, 1, -1, -1}, dy = {0, 1, -1, 0, 1, -1, 1, -1};
  static int[][] a;
  static HashMap<Integer, Point> h;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    a = new int[n][n];

    h = new HashMap<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        a[i][j] = Integer.parseInt(st.nextToken());
        h.put(a[i][j], new Point(i, j, a[i][j]));
      }
    }

    for (int i = 0; i < m; i++)
      calc();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        System.out.print(a[i][j] + " ");
      System.out.println();
    }
  }

  public static void calc() {
    for (int i = 1; i <= n * n; i++){
      Point p = h.get(i);

      int max = 0, x = -1, y = -1;
      for (int k = 0; k < 8; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny)) {
          if (max < a[nx][ny]) {
            max = a[nx][ny];
            x = nx;
            y = ny;
          }
        }
      }

      h.put(a[p.x][p.y], new Point(x, y, a[x][y]));
      h.put(a[x][y], new Point(p.x, p.y, a[p.x][p.y]));

      a[p.x][p.y] = h.get(a[p.x][p.y]).d;
      a[x][y] = h.get(a[x][y]).d;
    }
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
