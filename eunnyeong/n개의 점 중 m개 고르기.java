import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {

  static int n, m, ans;
  static int[] select;
  static Point[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new Point[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      a[i] = new Point(x, y);
    }

    ans = Integer.MAX_VALUE;
    select = new int[n];
    comb(0, 0);
    System.out.print(ans);
  }

  public static int calc(int x1, int y1, int x2, int y2) {
    return (int)Math.pow(x1 - x2, 2) + (int)Math.pow(y1 - y2, 2);
  }

  public static void comb(int idx, int cnt) {
    if (cnt == m) {
      int max = 0;
      for (int i = 0; i < m; i++) {
        for (int j = i + 1; j < m; j++) {
            int x = calc(a[select[i]].x, a[select[i]].y, a[select[j]].x, a[select[j]].y);
            max = Math.max(max, x);
        }
      }
      ans = Math.min(ans, max);
      return;
    }

    if(idx == n) 
        return;

    select[cnt] = idx;
    comb(idx + 1, cnt + 1);
    comb(idx + 1, cnt);
  }
}
