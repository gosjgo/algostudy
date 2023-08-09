import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

  static int n, m, k;
  static int[][] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    int x = 0, y = k + m - 2, f = 0;
    for (int i = 0; i < n; i++) {
      int cnt = 0;
      for (int k = 0; k < m; k++) {
        int nx = x + i, ny = y - k;
        if (a[nx][ny] != 0)
          cnt++;
      }
      if (cnt != 0) {
        for (int k = 0; k < m; k++) {
          int nx = x + i - 1, ny = y - k;
          a[nx][ny] = 1;
        }
        f = 1;
        break;
      }
    }

    if (f == 0) {
      for (int k = 0; k < m; k++) {
        int nx = x + n - 1, ny = y - k;
        a[nx][ny] = 1;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        System.out.print(a[i][j] + " ");
      System.out.println();
    }
  }
}
