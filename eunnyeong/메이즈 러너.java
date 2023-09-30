import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {

  static int n, m, k;
  static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
  static int[][] a;
  static Point[] people;
  static Point exit;
  static List[][] list;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    people = new Point[m + 1];
    list = new ArrayList[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        list[i][j] = new ArrayList<>();

    for (int i = 1; i <= m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      people[i] = new Point(x, y);
      a[x][y] += -1;
    }

    st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken()) - 1;
    int y = Integer.parseInt(st.nextToken()) - 1;
    exit = new Point(x, y);
    a[x][y] = -11; // 출구

    int sum = 0, cnt = 0;
    for (int i = 0; i < k; i++) {
      //이동
      for (int j = 1; j <= m; j++) {
        Point q = people[j];
        if (q.x == -2 && q.y == -2) continue;
        Point p = dist(q);
        if (a[p.x][p.y] <= 0) {
          sum++;

          if (a[p.x][p.y] != - 11) {
            a[p.x][p.y]--;
            people[j] = new Point(p.x, p.y);
          }
          else {
            cnt++;
            people[j] = new Point(-2, -2);
          }

          a[q.x][q.y]++;
        }
      }

      //회전
      search();
      if (cnt == m) break;
    }

    System.out.print(sum + "\n" + (exit.x + 1)+ " " + (exit.y + 1));
  }

  public static void rotate(int x1, int y1, int x2, int y2) {
    int[][] t1 = new int[n][n];
    for (int i = 0; i < n; i++)
      t1[i] = Arrays.copyOf(a[i], n);

    boolean[] visit = new boolean[m + 1];
    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++) {
        int x = a[x2 - (j - y1)][y1 + (i - x1)];
        if (x == -11)
          exit = new Point(i, j);
        else if (x < 0) {
          for (int k = 1; k <= m; k++) {
            Point p = people[k];
            if (!visit[k] && p.x == x2 - (j - y1) && p.y == y1 + (i - x1)) {
              people[k] = new Point(i, j);
              visit[k] = true;
            }
          }
        }

        if (x > 0)
          x--;

        t1[i][j] = x;
      }
    }

    for (int i = 0; i < n; i++)
      a[i] = Arrays.copyOf(t1[i], n);
  }

  public static int[] makeRange(Point p) {
    Point t, u;
    if (p.x >= exit.x) {
      if (p.y > exit.y) {
        t = p;
        u = exit;
      }
      else {
        t = exit;
        u = p;
      }
    }
    else {
      t = exit;
      u = p;
    }

    int x = Math.max(Math.abs(t.x - u.x), Math.abs(t.y - u.y));

    int x1 = 0, y1 = 0, x2 = x1 + x, y2 = y1 + x;
    while (true) {
      int f = 0;
      for (int i = x1; i <= x2; i++) {
        for (int j = y1; j <= y2; j++) {
          if ((i == t.x && j == t.y) || (i == u.x && j == u.y))
            f++;
          if (f == 2) break;
        }
      }

      if (f == 2) {
        int cnt = 0;
        for (int q = x1; q <= x2; q++)
          for (int r = y1; r <= y2; r++)
            cnt++;
        return new int[] {cnt, x1, y1, x2, y2};
      }
      else {
        y1++; y2++;
      }
      if (y2 == n) {
        x1++; x2++;
        y1 = 0; y2 = y1 + x;
      }
      if (x2 == n)
        break;
    }

    return null;
  }


  public static void search() { //출구 기준으로 가장 가까운 사람의 좌표 찾아서 범위 정하기
    boolean[][] visit = new boolean[n][n];
    Queue<Point> q = new ArrayDeque<>();
    q.add(exit);
    visit[exit.x][exit.y] = true;

    List<Point> list = new ArrayList<>();
    while (!q.isEmpty()) {
      Point p = q.poll();

      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny]) {
          q.add(new Point(nx, ny));
          visit[nx][ny] = true;
          if (a[nx][ny] != -11 && a[nx][ny] < 0)
            list.add(new Point(nx, ny));
        }
      }
    }

    int min = Integer.MAX_VALUE, x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    for (int i = 0; i < list.size(); i++) {
      int[] tmp = makeRange(list.get(i));
      if (min > tmp[0]) {
        min = tmp[0];
        x1 = tmp[1];
        y1 = tmp[2];
        x2 = tmp[3];
        y2 = tmp[4];
      }
      else if (min == tmp[0]) {
        if (x1 > tmp[1] || (x1 == tmp[1] && y1 > tmp[2])) {
          x1 = tmp[1];
          y1 = tmp[2];
          x2 = tmp[3];
          y2 = tmp[4];
        }
      }
    }

    rotate(x1, y1, x2, y2);
  }

  public static Point dist(Point p) { // 출구와 가까워지는 곳의 좌표
    int min = Integer.MAX_VALUE, x = -1, y = -1, d = 5;

    for (int k = 0; k < 4; k++) {
      int nx = p.x + dx[k], ny = p.y + dy[k];
      if (range(nx, ny)) {
        int t = Math.abs(exit.x - nx) + Math.abs(exit.y - ny);
        if (min > t) {
          min = t;
          x = nx;
          y = ny;
          d = k;
        }
        else if(min == t) {
          if (k < d || (a[x][y] > 0 && a[nx][ny] <= 0)) {
            x = nx;
            y = ny;
            d = k;
          }
        }
      }
    }

    return new Point(x, y);
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }
}
