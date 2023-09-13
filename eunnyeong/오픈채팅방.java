import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> h = new HashMap<>(); // id, 이름
        
        List<Pair> list = new ArrayList<>(); //id, 입장여부
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String a = st.nextToken();
            String b = st.nextToken();
            String c = "";
            if (!a.equals("Leave")) {
                c = st.nextToken();
                h.put(b, c);
            }
             if (!a.equals("Change"))
                list.add(new Pair(b, a));
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Pair p = list.get(i);
            String s = h.get(p.x) + "님이 ";
            
            if (p.y.equals("Enter"))
                s += "들어왔습니다.";
            else 
                s += "나갔습니다.";
                
            answer[i] = s;
        }
        
        return answer;
    }
}

class Pair {
    String x, y;
    
    public Pair (String x, String y) {
        this.x = x;
        this.y = y;
    }
}
