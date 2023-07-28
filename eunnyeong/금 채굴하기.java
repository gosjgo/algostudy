import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int x = n; x >= 0; x--) {
          int sum = 0, idx = 1;
          for (int k = j - x; k <= j + x; k++) {
            if (k >= 0 && k < n) {
              sum += a[i][k];
              for (int l = 1; l < idx; l++) {
                if (i - l >= 0)
                  sum += a[i - l][k];
                if (i + l < n)
                  sum += a[i + l][k];
              }
            }
            if (k >= j)
              idx--;
            else
              idx++;
          }

          int t = sum;
          t *= m;
          t -= (x * x) + ((x + 1) * (x + 1));
          if (t >= 0)
            ans = Math.max(ans, sum);
        }
      }
    }

    System.out.print(ans);
  }
}
