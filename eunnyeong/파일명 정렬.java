import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        PriorityQueue<File> q = new PriorityQueue<>();
        
        for (int i = 0; i < files.length; i++) {
            String s = files[i];
            int x = -1, y = -1, f = 0;
            for (int j = 0; j < s.length(); j++) {
                if (Character.isDigit(s.charAt(j))) {
                    if (x == -1)
                        x = j;
                }
                else {
                    if (x != -1) {
                        y = j;
                        f = 1;
                        break;
                    }
                }
            }
            
            if (f == 0)
                y = s.length();
            
            if (y == -1)
                y = x + 1;
            
            String head = s.substring(0, x).toUpperCase();
            int num = Integer.parseInt(s.substring(x, y));
            q.add(new File(head, num, i));
        }
        
        int idx = 0;
        while(!q.isEmpty()) 
            answer[idx++] = files[q.poll().order];
        
        return answer;
    }
}

class File implements Comparable<File>{
    String head;
    int num, order;
    
    public File(String head, int num, int order) {
        this.head = head;
        this.num = num;
        this.order = order;
    }
    
    @Override
    public int compareTo(File o) {
        if (this.head.equals(o.head)) {
            if (this.num == o.num)
                return this.order - o.order;
            return this.num - o.num;
        }
        return this.head.compareTo(o.head);
    }
}
