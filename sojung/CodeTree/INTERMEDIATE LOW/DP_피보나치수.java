import java.util.Scanner;

public class DP_피보나치수 {
    public static final int MAX_N = 45;
    public static int n;
    public static int[] memo = new int[MAX_N+1];
    public static int fivo(int num){
        if(memo[num] != -1) return memo[num];
        if(num<=2) return 1;

        else memo[num] = fivo(num-2) + fivo(num-1);

        return memo[num];

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1;i<=45;i++){
            memo[i]=-1;
        }
        System.out.print(fivo(n));
    }
}
