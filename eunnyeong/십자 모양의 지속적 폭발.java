import java.util.*;
import java.io.*;

public class Main {

  static int n;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};
  static int[][] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    int[] o = new int[m];
    for (int i = 0; i < m; i++)
      o[i] = Integer.parseInt(br.readLine()) - 1;

    for (int i = 0; i < m; i++) {
     int x = 0, y = o[i];
      if (a[x][y] == 0) {
        while (true) {
          if (a[x][y] != 0 || x == n - 1) break;
          x++;
        }
      }

      if (x == n - 1 && a[x][y] == 0) continue;

      for (int k = 0; k < 4; k++) {
        for (int j = 1; j <= a[x][y] - 1; j++) {
          int nx = x + dx[k] * j, ny = y + dy[k] * j;
          if (range(nx, ny))
            a[nx][ny] = 0;
        }
      }
      a[x][y] = 0;

      down();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        System.out.print(a[i][j] + " ");
      System.out.println();
    }
  }
  
  public static void down() {
    for (int i = 0; i < n; i++) {
      for (int j = n - 1; j >= 0; j--) {
        if (a[j][i] == 0) {
          int t = j;
          while (true) {
            if (t - 1 < 0) break;
            a[t][i] = a[t - 1][i];
            t--;
          }
          a[t][i] = 0;
        }
      }
    }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }
}
