import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

  static int n, m, ans;
  static int[][] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    ans = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
          for (int k = i; k < n; k++)
            for (int l = j; l < m; l++)
              makeSquare(i, j, k, l);

    System.out.print(ans);
  }

  public static boolean rangeCheck(Point p1, Point p4, Point r1, Point r4) {
    boolean[][] visit = new boolean[n][m];
    for (int i = p1.x; i <= p4.x; i++)
        for (int j = p1.y; j <= p4.y; j++)
            visit[i][j] = true;

    for (int i = r1.x; i <= r4.x; i++)
      for (int j = r1.y; j <= r4.y; j++)
        if (visit[i][j])
          return false;

    return true;
  }

  public static int sum(Point p1, Point p4, Point r1, Point r4) {
    int s = 0;

    for (int i = p1.x; i <= p4.x; i++)
      for (int j = p1.y; j <= p4.y; j++)
        s += a[i][j];

    for (int i = r1.x; i <= r4.x; i++)
      for (int j = r1.y; j <= r4.y; j++)
        s += a[i][j];

    return s;
  }

  public static void makeSquare (int x1, int y1, int x2, int y2) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int k = i; k < n; k++) {
          for (int l = j; l < m; l++) {
            Point p1 = new Point(x1, y1), p4 = new Point(x2, y2), r1 = new Point(i, j), r4 =  new Point(k, l);
            if (rangeCheck(p1, p4, r1, r4))
              ans = Math.max(ans, sum(p1, p4, r1, r4));
          }
        }
      }
    }
  }
}
