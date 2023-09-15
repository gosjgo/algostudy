import java.util.Scanner;

public class subproblem을그대로합치면되는DP_사각형채우기 {
    public static final int MAX_N = 1000;
    // 메모이제이션을 통해 시간복잡도를 O(2^N) 에서 O(N)으로 줄일 수 있다.
    public static int[] memo = new int[MAX_N+1];
    public static int n;
    public static int findCnt(int n){

        if(n<=1) return 1;
        //memo가 저장된다면 -1이 아니기에 -1이 아닐때는 memo[n]를 반환한다. 
        if(memo[n] != -1) return memo[n];
        //사각형 2*n의 경우의 수는 2*(n-2)의 경우 + 2*(n-1)의 경우
        else memo[n] = findCnt(n-2)+findCnt(n-1);

        return memo[n]%10007;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        //memo 배열에 모는 요소를 -1로 한다.
        for(int i=0;i<=MAX_N;i++){
            memo[i] = -1;
        }
        System.out.print(findCnt(n));
    }
}
