import java.util.*;
import java.io.*;

public class Main {

  static boolean[][] visit;
  static int n, cnt;
  static int[][] a;
  static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    int max = 0, block = 0;
    visit = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visit[i][j]) {
          cnt = 0;
          dfs(i, j);
          max = Math.max(max, cnt);
          if (cnt >= 4)
            block++;
        }
      }
    }

    System.out.print(block + " " + max);
  }

  public static void dfs(int x, int y) {
    if (visit[x][y]) return;
    visit[x][y] = true;
    cnt++;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i], ny = y + dy[i];
      if (range(nx, ny) && !visit[nx][ny] && a[x][y] == a[nx][ny])
        dfs(nx, ny);
    }
  }

  public static boolean range (int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < n) return true;
    return false;
  }
}
