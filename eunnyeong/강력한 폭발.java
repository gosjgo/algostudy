import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

  static int n, ans;
  static int[] dx = {1, 0, 0, -1, 1, 1, -1, -1}, dy = {0, 1, -1, 0, 1, -1, 1, -1};
  static List<Point> list;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    int[][] a = new int[n][n];
    list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        a[i][j] = Integer.parseInt(st.nextToken());
        if (a[i][j] == 1)
          list.add(new Point(i, j));
      }
    }

    ans = 0;
    sim(a, 0);

    System.out.print(ans);
  }

  public static void sim(int[][] a, int d) {
    if (d == list.size()) {
      int cnt = 0;
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          if (a[i][j] == 1)
            cnt++;

      ans = Math.max(ans, cnt);
      return;
    }

    int[][] t = new int[n][n];
    t = copy(a, t);
    sim(b1(t, list.get(d)), d + 1);
    t = copy(a, t);
    sim(b2(t, list.get(d), 1), d + 1);
    t = copy(a, t);
    sim(b2(t, list.get(d), 2), d + 1);
  }

  public static int[][] copy(int[][] a, int[][] t) {
    t = new int[n][n];
    for (int i = 0; i < n; i++)
      t[i] = Arrays.copyOf(a[i], n);
    return t;
  }

  public static int[][] b1(int[][] a, Point p) {
    int idx = 1;
    for (int i = 1; i <= 2; i++) {
      int nx = p.x + idx++, ny = p.y;
      if (range(nx, ny))
        a[nx][ny] = 1;
    }

    idx = -1;
    for (int i = 1; i <= 2; i++) {
      int nx = p.x + idx--, ny = p.y;
      if (range(nx, ny))
        a[nx][ny] = 1;
    }

    return a;
  }

  public static int[][] b2(int[][] a, Point p, int t) {
    int x = 0, y = 0;
    if (t == 2)
      y = 4;
    else {
      x = 4; y = 8;
    }
    for (int k = x; k < y; k++) {
      int nx = p.x + dx[k], ny = p.y + dy[k];
      if (range(nx, ny))
        a[nx][ny] = 1;
    }
    return a;
  }

  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < n) return true;
    return false;
  }
}
