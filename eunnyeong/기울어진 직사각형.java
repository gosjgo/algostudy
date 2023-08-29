import java.util.*;
import java.io.*;

public class Main {

  static int n;
  static int[][] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          for (int k = 1; k < n; k++)
            for (int l = 1; l < n; l++)
              ans = Math.max(ans, calc(i, j, k, l));

    System.out.print(ans);
  }

  public static int calc (int x, int y, int k, int l) {
    int[] dx = {-1, -1, 1, 1}, dy = {1, -1, -1, 1}, move = {k, l, k, l};

    int sum = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < move[i]; j++) {
        x += dx[i]; y += dy[i];

        if (!range(x, y))
          return 0;

        sum += a[x][y];
      }
    }

    return sum;
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }
}
