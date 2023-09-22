import java.util.Scanner;

public class 정수사각형최대합 {
    public static final int MAX_N = 100;
    // 처음 격자의 숫자 구성
    public static int[][] board = new int[MAX_N][MAX_N];
    // 숫자의 합이 최대값인 숫자 구성
    public static int[][] score = new int[MAX_N][MAX_N];
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        // 0.0 에 처음 수를 넣어준다.
        score[0][0] = board[0][0];
        // 시작지점부터 가로세로는 경우의수가 한개밖에 없어서 쭉 더해준다.
        for (int i = 1; i < n; i++) {
            score[0][i] = score[0][i - 1] + board[0][i];
            score[i][0] = score[i - 1][0] + board[i][0];
        }
        // score에 저장된 수를 기반으로 최대값이 되도록 나머지를 채워준다.
        // 작은 문제가 먼저 풀려있다는 가정하에서 큰 문제가 풀리게된다.
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                score[i][j] = Math.max(score[i - 1][j], score[i][j - 1]) + board[i][j];
            }
        }

        System.out.print(score[n - 1][n - 1]);

    }
}