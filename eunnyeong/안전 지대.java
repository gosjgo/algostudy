import java.util.*;
import java.io.*;

public class Main {

  static boolean[][] visit;
  static int n, m, mk, ma;
  static int[][] a;
  static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n][m];
    int max = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        a[i][j] = Integer.parseInt(st.nextToken());
        max = Math.max(max, a[i][j]);
      }
    }

    mk = 1; ma = 0;
    for (int i = 1; i <= max; i++)
      calc(i);

    System.out.print(mk + " " + ma);
  }

  public static void calc(int k) {
    visit = new boolean[n][m];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (a[i][j] <= k)
          visit[i][j] = true;

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visit[i][j]) {
          cnt++;
          dfs(i, j);
        }
      }
    }

    if (ma < cnt) {
      ma = cnt;
      mk = k;
    }
  }

  public static void dfs(int x, int y) {
    if (visit[x][y]) return;
    visit[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i], ny = y + dy[i];
      if (range(nx, ny) && !visit[nx][ny])
        dfs(nx, ny);
    }
  }

  public static boolean range (int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < m) return true;
    return false;
  }
}
