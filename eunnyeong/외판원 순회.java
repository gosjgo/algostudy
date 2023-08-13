import java.util.*;
import java.io.*;

public class Main {

  static int n, ans;
  static int[][] a;
  static int[] select, num;
  static boolean[] visit;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    num = new int[n - 1];
    for (int i = 0; i < n - 1; i++)
      num[i] = i + 1;

    select = new int[n - 1];
    visit = new boolean[n - 1];
    ans = Integer.MAX_VALUE;
    perm(0);

    System.out.print(ans);
  }

  public static void perm(int cnt) {
    if(cnt == n - 1) {
      int sum = a[0][select[0]];
      if (sum == 0) return;
      for (int i = 0; i < n - 2; i++) {
        int x = a[select[i]][select[i + 1]];
        if (x == 0) return;
        sum += x;
      }
      if (a[select[n - 2]][0] == 0) return;
      sum += a[select[n - 2]][0];

      ans = Math.min(ans, sum);
      return;
    }

    for (int i = 0; i < n - 1; i++) {
      if(!visit[i]) {
        visit[i] = true;
        select[cnt] = num[i];
        perm(cnt + 1);
        visit[i] = false;
      }
    }
  }
}
