import java.util.*;
import java.io.*;

public class Main {

  static int n;
  static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
  static char[][] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken()) - 1;
    int y = Integer.parseInt(st.nextToken()) - 1;

    a = new char[n][n];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < n; j++)
        a[i][j] = s.charAt(j);
    }

    int d = 0, cnt = 0;
    int[][] visit = new int[n][n];
    for (int i = 0; i < n; i++)
      Arrays.fill(visit[i], -1);

    while (true) {
      if (visit[x][y] != -1 && visit[x][y] == d) {
        cnt = -1;
        break;
      }
      int nx = x + dx[d], ny = y + dy[d];

      if (!range(nx, ny)) {
        cnt++;
        break;
      }

     if (a[nx][ny] == '#') { // 앞이 벽인 경우
       d = rot2(d);
       if (visit[nx][ny] == d) {
         cnt = -1;
         break;
       }
       visit[nx][ny] = d;
     }
     else {
       visit[x][y] = d;
       int t = rot1(d);
       int tx = nx + dx[t], ty = ny + dy[t];
       if (a[tx][ty] == '.') //앞이 벽은 아닌데 방향을 전환해야 하는 경우
         d = t;
       x = nx; y = ny;
       cnt++;
     }
    }

    System.out.print(cnt);
  }

  public static int rot1(int x) { // 시계
    if (x == 0) return 2;
    if (x == 1) return 3;
    if (x == 2) return 1;
    if (x == 3) return 0;
    return -1;
  }

  public static int rot2(int x) { // 빈시계
    if (x == 0) return 3;
    if (x == 1) return 2;
    if (x == 2) return 0;
    if (x == 3) return 1;
    return -1;
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }
}
