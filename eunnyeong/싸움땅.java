import java.util.*;
import java.io.*;

public class Main {

  static int n, m, k;
  static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}, ans;
  static PriorityQueue[][] list; //총(Gun) 목록
  static User[] u;//회원 정보
  static int[][] info; //사람 좌표, 회원 idx 저장

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    int[][] a = new int[n][n];
    info = new int[n][n];
    list = new PriorityQueue[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      Arrays.fill(info[i], -1);
      for (int j = 0; j < n; j++) {
        list[i][j] = new PriorityQueue<Integer>(Comparator.reverseOrder());
        a[i][j] = Integer.parseInt(st.nextToken());
        if (a[i][j] != 0)
          list[i][j].add(a[i][j]);
      }
    }

    u = new User[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      int d = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());

      info[x][y] = i;
      u[i] = new User(x, y, d, s, 0);
    }

    ans = new int[m];
    for (int i = 0; i < k; i++)
      for (int j = 0; j < m; j++)
        move(j, 0);

    for (int i = 0; i < m; i++)
      System.out.print(ans[i] + " ");
  }

  public static int move(int idx, int d) {
    User p = u[idx];
    int nx = p.x + dx[p.d], ny = p.y + dy[p.d];
    if (range(nx, ny)) {
      if (info[nx][ny] == -1) { // 그 칸에 아무도 없을 때
        info[p.x][p.y] = -1;
        info[nx][ny] = idx;
        u[idx].x = nx;
        u[idx].y = ny;
        take(nx, ny, idx);
      }
      else {
        if (d == 0)
          fight(idx, info[nx][ny]);
        else
          rotate(idx);
      }
    }
    else {
      if (d == 1) return 2;
      u[idx].d = change(u[idx].d);
      move(idx, 0);
    }

    return 0;
  }

  public static void rotate(int idx) {
    for (int i = 0; i < 4; i++) {
      u[idx].d++;
      if (u[idx].d == 4)
        u[idx].d = 0;
      int t = move(idx, 1);
      if (t == 0)
        return;
    }
  }

  public static void fight(int idx, int qdx) {
    User p = u[idx];
    int nx = p.x + dx[p.d], ny = p.y + dy[p.d];

    User q = u[qdx];
    int pt = p.s + p.g, qt = q.s + q.g;
    if (pt < qt || (pt == qt && p.s < q.s)) { //원래 있던 사람이 이김
      ans[qdx] += qt - pt;

      if (p.g != 0) {
        list[nx][ny].add(p.g);
        u[idx].g = 0;
      }
      take(q.x, q.y, qdx);

      info[p.x][p.y] = -1;
      u[idx].x = nx;
      u[idx].y = ny;
      int t = move(idx, 1);
      if (t != 0)
        rotate(idx);

      info[nx][ny] = qdx;
    }
    else { //새로 온 사람이 이김
      ans[idx] += pt - qt;
     
      if (q.g != 0) {
        list[nx][ny].add(q.g);
        u[info[nx][ny]].g = 0;
      }
      info[nx][ny] = -1;
      move(idx, 0);
      int t = move(qdx, 1);
      if (t != 0)
        rotate(qdx);

      info[u[idx].x][u[idx].y] = idx;
      take(u[qdx].x, u[qdx].y, qdx);
    }
  }

  public static void take(int x, int y, int idx) {
    if (!list[x][y].isEmpty()) {
      if (u[idx].g < (Integer)list[x][y].peek()) {
        if (u[idx].g != 0)
          list[x][y].add(u[idx].g);
        u[idx].g = (Integer)list[x][y].poll();
      }
    }
  }

  public static int change(int d) {
    if (d == 0) return 2;
    if (d == 1) return 3;
    if (d == 2) return 0;
    if (d == 3) return 1;
    return -1;
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }

  public static class User {
    int x, y, d, s, g;

    public User(int x, int y, int d, int s, int g) {
      this.x = x;
      this.y = y;
      this.d = d;
      this.s = s;
      this.g = g;
    }
  }
}
