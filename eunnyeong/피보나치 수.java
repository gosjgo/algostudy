import java.util.*;

public class Main {

    static int[] memo;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        memo = new int[n + 1];
        System.out.print(dp(n));
    }

    public static int dp(int n) {
        if (memo[n] != 0) 
            return memo[n];

        if (n == 1 || n == 2) 
            return memo[n] = 1;
        else memo[n] = dp(n - 1) + dp(n - 2);
        
        return memo[n];
    }
}
