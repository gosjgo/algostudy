import java.util.*;
import java.util.Map.Entry;

class Solution {
    
    char[] select;
    HashMap<String, Integer> ans;
    
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            orders[i] = String.valueOf(c);
        }
      
        List<String> list = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int x = course[i];
            
            ans = new HashMap<>();
            for (int j = 0; j < orders.length; j++) {
                if (x <= orders[j].length()) {
                    select = new char[x];
                    comb(0, 0, x, orders[j].toCharArray());
                }
            }
            int max = 0;
            for (Integer j : ans.values())
                max = Math.max(max, j);
            
            for (Entry<String, Integer> entry : ans.entrySet())
                if (max >= 2 && entry.getValue() == max)
                    list.add(entry.getKey());
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        int idx = 0;
        for (String i : list)
            answer[idx++] = i;
            
        return answer;
    }
    
    public void comb(int cnt, int idx, int d, char[] a) {
        if (cnt == d) {
            String s = new String(select);
            ans.put(s, ans.getOrDefault(s, 0) + 1);
            return;
        }
        for (int i = idx; i < a.length; i++) {
            select[cnt] = a[i];
            comb(cnt + 1, i + 1, d, a);
        }
    }
}
