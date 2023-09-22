import java.util.*;
import java.io.*;

public class Main {

  static int[][] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    a = new int[4][4];
    for (int i = 0; i < 4; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 4; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    char c = br.readLine().charAt(0);

    int idx = 0;
    if (c == 'R')
      idx = 1;
    else if (c == 'L')
      idx = 3;
    else if (c == 'U')
      idx = 2;

    for (int i = 0; i < idx; i++)
      rotate();

    calc();

    for (int i = 0; i < 4 - idx; i++)
      rotate();

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++)
        System.out.print(a[i][j] + " ");
      System.out.println();
    }
  }

  public static void rotate() {
    int[][] tmp = new int[4][4];

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        tmp[i][j] = a[3 - j][i];
      }
    }

    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        a[i][j] = tmp[i][j];
  }

  public static void calc() {
    for (int i = 0; i < 4; i++) {
      for (int j = 3; j > 0; j--) {
        if (a[j - 1][i] == 0) {
          int idx = 1;
          while (true) {
            if (j - idx - 1 < 0) break;
            a[j - idx][i] = a[j - idx - 1][i];
            idx++;
          }
          a[0][i] = 0;
        }

        if (a[j][i] == 0) {
          int idx = 0;
          while (true) {
            if (j - idx - 1 < 0) break;
            a[j - idx][i] = a[j - idx - 1][i];
            idx++;
          }
          a[0][i] = 0;
        }

        int x = a[j][i];
        int y = a[j - 1][i];

        if (x == y) {
          a[j][i] = x + y;
          a[j - 1][i] = 0;
        }
      }
      if (a[3][i] == 0) {
        int idx = 0;
        while (true) {
          if (3 - idx - 1 < 0) break;
          a[3 - idx][i] = a[3 - idx - 1][i];
          idx++;
        }
        a[0][i] = 0;
      }
    }
  }
}
