
    class JadenCase문자열만들기 {
        public String solution(String s) {
            String answer = "";
            String[] str = answer.split("");
            str[0] = str[0].toUpperCase();

            for(int i=1;i<str.length;i++){
                if(str[i-1].charAt(0) ==' ') str[i] = str[i].toUpperCase();
                else str[i].toLowerCase();
            }

            for(String x : str){
                answer += x;
            }
            return answer;
        }
    }
