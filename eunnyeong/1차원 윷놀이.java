import java.util.*;
import java.io.*;

public class Main {

  static int n, m, k, ans;
  static int[] a, select;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    select = new int[k];
    ans = 0;
    perm(0);

    System.out.print(ans);
  }
  public static void perm(int cnt) {
    int t = 0;
    for (int i = 0; i < k; i++)
      if (select[i] >= m - 1)
        t++;
    ans = Math.max(ans, t);

    if (cnt == n) return;

    for (int i = 0; i < k; i++) {
      if (select[i] >= m - 1)
        continue;
      select[i] += a[cnt];
      perm(cnt + 1);
      select[i] -= a[cnt];
    }
  }
}
