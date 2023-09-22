public class 숫자문자열과영단어 {

    public int solution(String s) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        // 영어로 표현되어있는 수를 순서대로 숫자로 바꾼다. str.replace("바뀌기전","바꾼후")
        for (int i = 0; i < 10; i++) {
            s = s.replace(words[i], nums[i]);
        }
        int answer = Integer.valueOf(s);
        return answer;
    }

}
