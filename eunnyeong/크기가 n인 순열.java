import java.util.*;

public class Main {

    static int n;
    static int[] select;
    static boolean[] visit;

    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);

       n = s.nextInt();
       select = new int[n];
       visit = new boolean[n];
       
       perm(0);
    }

    public static void perm(int cnt) {
        if (cnt == n) {
            for (int i = 0; i < n; i++)
                System.out.print(select[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i - 1]) {
                select[cnt] = i;
                visit[i - 1] = true;
                perm(cnt + 1);
                visit[i - 1] = false;
            }
        }
    }
}
