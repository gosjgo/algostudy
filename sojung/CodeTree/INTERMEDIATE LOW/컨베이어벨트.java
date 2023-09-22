import java.util.Scanner;

public class 컨베이어벨트 {
    public static final int MAX_N = 200;
    public static int n, t;
    //위 컨테이너, 아래 컨테이너를 두개의 배열로 저장한다.
    public static int[] arr1 = new int[MAX_N];
    public static int[] arr2 = new int[MAX_N];

    //컨테이너가 1초 돌때마다 이동하는 함수
    public static void move() {
        // 윗줄의 맨 마지막과 아랫줄의 맨 마지막를 tmp1,tmp2에 담는다.
        int tmp1 = arr1[n - 1];
        int tmp2 = arr2[0];
        // 윗줄은 뒤에서부터 앞의 수를 저장한다.
        for (int i = n - 1; i > 0; i--) {
            arr1[i] = arr1[i - 1];
        }
        // 윗줄의 제일 처음수는 tmp2를 저장한다.
        arr1[0] = tmp2;
        // 아랫줄은 앞에서부터 뒤의 수를 저장한다.
        for (int i = 0; i < n - 1; i++) {
            arr2[i] = arr2[i + 1];
        }
        //아랫줄의 제일 마지막에는 tmp1를 저장한다.
        arr2[n - 1] = tmp1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        // 위에 수를 배열 arr1에 저장한다.
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        // 밑에 수를 배열 arr2에 저장하는데 이때 거꾸로 저장한다.
        for (int i = n - 1; i >= 0; i--) {
            arr2[i] = sc.nextInt();
        }
        //t번 move() 함수를 반복한다.
        for (int i = 0; i < t; i++) {
            move();
        }
        //arr1수를 출력한다.
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        //arr2 수를 거꾸로 출력한다.
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr2[i] + " ");
        }


    }
}