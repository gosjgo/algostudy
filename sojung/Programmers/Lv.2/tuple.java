import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class tuple {
    public int[] solution(String s) {

        ArrayList<Integer> list = new ArrayList<>();
        // 1. 앞 뒤의 {{ }}를뺀다
        s = s.substring(2, s.length());
        s = s.substring(0, s.length() - 2);
        // 2. },{ 기준으로 수의 배열을 나눌 수 있으니. -로 바꿔주고 split해준다.
        s = s.replace("},{", "-");
        String[] nums = s.split("-");
        // 3. nums 배열을 길이 순서대로 정렬을 하면 수의 개수가 점점 늘어나는 과정을 담을 수 있다.
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        // 4. nums 에 있는 문자열 순서대로 ,를 기준으로 수를 임시적으로 배열에 저장한 후
        // 5. 답이 담겨질 ArrayList에 순차적으로 수를 저장한다.
        // * 이 때 이미 담겨져 있는 수 이면 앞에서 저장된 수 이기 때문에 안 담겨져 있는 수만 저장한다.
        for (String x : nums) {
            String[] temp = x.split(",");
            for (String tmpS : temp) {
                if (!list.contains(Integer.valueOf(tmpS))) list.add(Integer.valueOf(tmpS));
            }
        }

        int[] answer = new int[list.size()];
        // 답이 될 배열에 ArrayList에 있는 수를 순차적으로 저장해서 반환한다.
        for (int i = 0; i < list.size(); i++) {

            answer[i] = list.get(i);

        }

        return answer;
    }
}