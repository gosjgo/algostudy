import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;

        System.out.print(dp[n - 1]);
    }
}
