import java.util.*;
import java.io.*;

public class Main {

  static int n, ans;
  static int[] select, a;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    a = new int[n * 2];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n * 2; i++)
      a[i] = Integer.parseInt(st.nextToken());

    ans = Integer.MAX_VALUE;
    select = new int[n];
    comb(0, 0);
    System.out.print(ans);
  }

  public static void comb(int idx, int cnt) {
    if (cnt == n) {
      boolean[] visit = new boolean[a.length];
      int s1 = 0, s2 = 0;
      for (int i = 0; i < n; i++) {
        s1 += a[select[i]];
        visit[select[i]] = true;
      }

      for (int i = 0; i < a.length; i++)
        if (!visit[i])
          s2 += a[i];

      ans = Math.min(ans, Math.abs(s1 - s2));
      return;
    }

    for (int i = idx; i < a.length; i++) {
      select[cnt] = i;
      comb(i + 1, cnt + 1);
    }
  }
}
