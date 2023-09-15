import java.util.Scanner;

public class subproblem을그대로합치면되는DP_사각형채우기3 {
    public static final int MOD = 1000000007;
    public static final int MAX_N = 1000;
    public static long[] dp = new long[MAX_N+1];
    public static int n;
    public static void main(String[] args) {
        // 메모이제이션 배열 초기값을 모두 -1로 한다.
        dp[0] = 1;
        dp[1] = 2;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for( int i = 2 ; i<=n; i++){
            dp[i] = (dp[i-2]*3+dp[i-1]*2)%MOD;
            for(int j = i-3;j>=0;j--){
                dp[i] = (dp[i]+dp[j]*2)%MOD;
            }
        }

        System.out.print(dp[n]);
        
    }
}
