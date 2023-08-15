import java.util.*;
import java.io.*;

public class Main {

  static int k, n;
  static int[] a, select;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    k = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    a = new int[k];
    for (int i = 1; i <= k; i++)
      a[i - 1] = i;

    select = new int[n];
    comb(0, 0);
  }

  public static void comb(int idx, int cnt) {
    if (cnt == n) {
      for (int i = 0; i < n; i++)
        System.out.print(select[i] + " ");
      System.out.println();
      return;
    }

    for (int i = idx; i < k; i++) {
      select[cnt] = a[i];
      int t = select[0], chk = 1;
      for (int j = 1; j <= cnt; j++) {
        if (t == select[j]) chk++;
        else {
          t = select[j];
          chk = 1;
        }
        if (chk >= 3) break;
      }
      if (chk >= 3) continue;
      comb(idx, cnt + 1);
    }
  }
}
