import java.util.*;
import java.io.*;

public class Main {

  static int n, ans;
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

    ans = 0;

    for (int i = 0; i < n; i++) {
      int[] visit = new int[n];
      visit[0] = i;
      dfs(1, visit);
    }

    System.out.print(ans);
  }

  public static void dfs(int d, int[] visit) {
    if (d == n) {
      int x = Integer.MAX_VALUE;

      for (int i = 0 ; i < n; i++)
        x = Math.min(x, a[i][visit[i]]);

      ans = Math.max(ans, x);
      return;
    }

    boolean[] check = new boolean[n];
    for (int i = 0; i < d; i++)
      check[visit[i]] = true;

    for (int i = 0; i < n; i++) {
      if (!check[i]) {
        visit[d] = i;
        dfs(d + 1,  visit);
      }
    }
  }
}
