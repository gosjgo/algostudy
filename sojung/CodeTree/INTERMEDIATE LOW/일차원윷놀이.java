import java.util.Scanner;

public class 일차원윷놀이 {
    public static final int MAX_N = 12;
    public static final int MAX_M = 100;
    public static final int MAX_K = 4;

    public static int n, m, k;
    public static int ans;

    public static int[] scoreArr = new int[MAX_N];
    public static int[] playerArr = new int[MAX_K];

    public static int cal() {
        int score = 0;
        for (int i = 0; i < k; i++) {
            if (playerArr[i] >= m) score++;
        }
        return score;
    }

    public static void findMax(int curr) {
        ans = Math.max(ans, cal());

        if (curr == n) return;

        for (int i = 0; i < k; i++) {
            playerArr[i] += scoreArr[curr];
            findMax(curr + 1);
            playerArr[i] -= scoreArr[curr];
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            playerArr[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            scoreArr[i] = sc.nextInt();
        }
        findMax(0);

        System.out.print(ans);

    }
}