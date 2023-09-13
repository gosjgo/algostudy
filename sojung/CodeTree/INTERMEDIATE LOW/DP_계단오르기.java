import java.util.Scanner;

public class Main {
    public static final int MOD = 10007;
    public static final int MAX_N = 1000;
    public static int[] memo = new int[MAX_N+1];
    public static int n;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        memo[1] = 0;
        memo[2] = 1;
        memo[3] = 1;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); 

        for(int i=4;i<=n;i++){
            memo[i] = (memo[i-2]+memo[i-3])%MOD;
        }
        System.out.print(memo[n]);
    }
}
