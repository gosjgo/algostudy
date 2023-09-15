import java.util.Scanner;
import java.util.ArrayList;

public class K개중하나를N번선택하기_특정 조건에맞게k개중에1개를n번뽑기 {
    public static int k,n;
    //ArrayList를 만들어서 수를 넣고 출력용으로 쓴다.
    public static ArrayList<Integer> list = new ArrayList<>();
    //자리수만큼 숫자가 리스트에 찾을때 출력하는 메서드 print()
    public static void print(){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
    //자리수에 수를 대입해주고 자리수가 다차면 print() 호출하는 함수 choose
    public static void choose(int currNum){
        if(currNum>n){
            print();
            return;
        }
        //반복문을 통해 1~K까지 차례대로 대입한다.
        for(int i=1;i<=k;i++){
            // 연속해서 숫자가 3번 이상 나오면 안되기 때문에 조건을 건다.
            // 자리수가 2이하인 경우는 괜찮다.
            // 직전 수가 이번수와 같지 않거나 전전수가 이번수와 같지 않으면 괜찮다.
            if(currNum <=2 || list.get(list.size()-1)!=i||list.get(list.size()-2)!=i){
                list.add(i);
                choose(currNum+1);
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        //한자리수부터 시작
        choose(1);
    }
}
