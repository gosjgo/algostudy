import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

  static int ans;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());

    ans = Integer.MAX_VALUE;
    bfs(n);
    System.out.println(ans);
  }

  public static void bfs(int n) {
    int[] visit = new int[n + 3];
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(n, 0));

    while (!q.isEmpty()) {
      Point p = q.poll();
      
      if (p.x == 1) {
        ans = Math.min(ans, p.y);
        break;
      }
      else {
        if (p.x < n + 3 && p.x >= 0 && (visit[p.x] == 0 || visit[p.x] > p.y)) {
          visit[p.x] = p.y;
          if (p.x % 3 == 0)
            q.add(new Point(p.x / 3, p.y + 1));
          if (p.x % 2 == 0)
            q.add(new Point(p.x / 2, p.y + 1));
          q.add(new Point(p.x - 1, p.y + 1));
          q.add(new Point(p.x + 1, p.y + 1));
        }
      }
    }
  }
}
