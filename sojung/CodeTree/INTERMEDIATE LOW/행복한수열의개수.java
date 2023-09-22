import java.util.Scanner;


public class 행복한수열의개수 {
    public static final int MAX_N = 100;
    public static int n, m;
    // 격자안에 있는 숫자를 저장한다.
    public static int[][] board = new int[MAX_N][MAX_N];

    // 기준에 있는 숫자와 같은 지 따져보기전에 outOfIndex가 아닌지 확인하는 함수 inRange
    public static boolean inRange(int a, int b) {
        if (0 <= a && a < n && 0 <= b && b < n) return true;
        return false;
    }

    // 행 기준으로 수열에 m만큼 반복되는 수가 있는지 확인한다.
    public static boolean checkedRow(int a, int b) {

        for (int i = 1; i < m; i++) {
            //범위안에 수가 아니라면 바로 반복되지 않는다고 false를 리턴한다.
            if (!inRange(a, b - i)) return false;
            //수가 다르면 바로 false를 리턴한다.
            if (board[a][b - i] != board[a][b]) return false;
        }
        return true;
    }

    // 열 기준으로 수열에 m만큼 반복되는 수가 있는지 확인한다.
    public static boolean checkedColumn(int a, int b) {
        for (int i = 1; i < m; i++) {
            if (!inRange(a - i, b)) return false;
            if (board[a - i][b] != board[a][b]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        // 행 기준으로 나눠서 반복되는게 확인되면 바로 break를 해서 행단위로 끊어서 검사한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (checkedRow(i, j)) {
                    ans++;
                    break;
                }
            }
        }
        // 열 기준으로 나눠서 반복되는게 확인되면 break를 해서 열 단위로 끊어서 검사한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (checkedColumn(j, i)) {
                    ans++;
                    break;
                }
            }
        }
        System.out.print(ans);
    }
}