import java.util.*;
import java.awt.Point;

class Solution {
    int[] select, dis = {10, 20, 30, 40}, emo;
    int n;
    List<Point> list;
    int[][] u;
    
    public int[] solution(int[][] users, int[] emoticons) {
        n = emoticons.length;
        u = users; emo = emoticons;
        
        select = new int[n];
        list = new ArrayList<>();
        perm(0);
        
        Collections.sort(list, new Comparator<>(){
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x == o2.x)
                    return o2.y - o1.y;
                return o2.x - o1.x;
            }
        });
        
        Point p = list.get(0);
        int[] answer = {p.x, p.y};
        return answer;
    }
    
    public void calc() {
        int cnt = 0, rslt = 0;
        for (int i = 0; i < u.length; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++)
                if (select[j] >= u[i][0])
                    sum += emo[j] * ((double)(100 - select[j]) / 100);
            
            if (sum >= u[i][1])
                cnt++;
            else
                rslt += sum;
        }
        list.add(new Point(cnt, rslt));
    }
    
    public void perm(int cnt) {
        if (cnt == n) {
            calc();
            return;
        }
        for (int i = 0; i < 4; i++) {
            select[cnt] = dis[i];
            perm(cnt + 1);
        }
    }
}
