class 로또의최고순위와최저순위 {
    public static int ranking(int num){
        if(num==6) return 1;
        else if(num==5) return 2;
        else if(num==4) return 3;
        else if(num==3) return 4;
        else if(num==2) return 5;
        else return 6;
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int score = 0; // 로또에서 처음에 같은 숫자의 개수
        int countZ = 0; // 0의 개수
        // 로또에서 같은 수가 나오는 점수를 계산한다.
        for(int x:lottos){
            for(int y:win_nums){
                if(x==y) score++;
            }
            if(x==0) countZ++;
        }

        answer = new int[2];
        answer[0] = ranking(score + countZ);
        answer[1] = ranking(score);

        return answer;
    }
}
