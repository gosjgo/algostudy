import java.util.*;
import java.io.*;

public class Main {

  static int ans;
  static int[] select;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    ans = 0;

    select = new int[n];
    perm(0, n);

    System.out.print(ans);
  }

  public static void perm(int cnt, int d) {
    if (cnt == d) {
      String n = "";
      for (int i = 0; i < d; i++)
        n += select[i];

      check(n);
      return;
    }
    for (int i = 1; i <= 4; i++) {
      select[cnt] = i;
      perm(cnt + 1, d);
    }
  }

  public static void check(String n) {
    int x = n.charAt(0) - '0', y = 0, cnt = 1;
    if (n.length() == 1) {
      if (n.equals("1"))
        ans++;
      return;
    }
    for (int i = 1; i < n.length(); i++) {
      y = n.charAt(i) - '0';

      if (x != y) {
        if (x != 1 && (cnt %= x) != 0) return;
        cnt = 1;
        x = y;
      }
      else cnt++;
    }
    if (y != 1 &&(cnt %= y) != 0) return;

    ans++;
  }
}
