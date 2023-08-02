import java.util.*;
import java.io.*;
import java.awt.Point;
public class Main {

  static int n, max, ans;
  static int[] select;
  static Point[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    a = new Point[n];

    max = 0;
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      a[i] = new Point(x, y);
      max = Math.max(max, x);
      max = Math.max(max, y);
    }

    ans = 0;
    for (int i = n; i >= 0; i--) {
      select = new int[i];
      comb(0, 0, i);
      if (ans != 0) break;
    }

    System.out.print(ans);
  }
  public static void comb(int idx, int cnt, int d) {
    if (cnt == d) {
      boolean[] visit = new boolean[max + 1];
      for (int i = 0; i < d; i++) {
        Point p = a[select[i]];
        for (int j = p.x; j <= p.y; j++) {
          if (!visit[j])
            visit[j] = true;
          else
            return;
        }
      }
      ans = Math.max(ans, d);
      return;
    }

    for (int i = idx; i < n; i++) {
        select[cnt] = i;
        comb(i + 1, cnt + 1, d);
    }
  }
}
