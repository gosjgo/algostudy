import java.util.*;
import java.io.*;

public class Main {

  static int n, m, ans;
  static int[] select, a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    ans = 0;
    select = new int[m];
    comb(0, 0);
    
    System.out.print(ans);
  }

  public static void comb(int idx, int cnt) {
    if (cnt == m) {
      int x = select[0];
      for (int i = 1; i < m; i++)
        x ^= select[i];
      
      ans = Math.max(ans, x);
      return;
    }

    for (int i = idx; i < n; i++) {
      select[cnt] = a[i];
      comb(i + 1, cnt + 1);
    }
  }
}
