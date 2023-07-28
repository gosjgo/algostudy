import java.util.*;
import java.io.*;

public class Main {

    static int n, m, ans;
    static int[][] a;
    
    public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        //ㄴ
        int[] ax = {0, -1, 0}, ay = {0, 0, 1};
        check(ax, ay);
        //ㄴ 반대
        ay[2] = -1;
        check(ax, ay);
        //ㄱ
        ax[1] = 1;
        check(ax, ay);
        //ㄱ 반대
        ay[2] = 1;
        check(ax, ay);

        //가로
        int[] bx = {0, 0, 0}, by = {0, 1, 2};
        check(bx, by);
        //세로
        int[] cy = {0, 0, 0}, cx = {0, 1, 2};
        check(cx, cy);

        System.out.print(ans);
    }

    public static void check(int[] dx, int[] dy) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0, cnt = 0;
                for (int k = 0; k < 3; k++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if (range(nx, ny)) {
                        cnt++;
                        sum += a[nx][ny];
                    }
                }

                if(cnt == 3)
                    ans = Math.max(ans, sum);
            }
        }
    }
    
    public static boolean range(int nx, int ny) {
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) return true;
        return false;
    }
}
