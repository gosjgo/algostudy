import java.util.*;
import java.io.*;

public class Main {

  static boolean[][] visit;
  static int n, m, ans;
  static int[][] a;
  static int[] dx = {0, 1}, dy = {1, 0};

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

    visit = new boolean[n][m];
    ans = 0;

    dfs(0, 0);
    System.out.print(ans);
  }

  public static void dfs(int x, int y) {
    if (x == n - 1 && y == m - 1) {
      ans = 1;
      return;
    }
    if (visit[x][y]) return;
    visit[x][y] = true;

    for (int i = 0; i < 2; i++) {
      int nx = x + dx[i], ny = y + dy[i];
      if (range(nx, ny) && !visit[nx][ny] && a[nx][ny] == 1)
        dfs(nx, ny);
    }
  }

  public static boolean range (int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < m) return true;
    return false;
  }
}
