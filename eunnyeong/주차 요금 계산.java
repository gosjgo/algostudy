import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Time[] list = new Time[records.length];
        
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            String s = st.nextToken();
            int h = Integer.parseInt(s.substring(0, 2));
            int m = Integer.parseInt(s.substring(3, 5));
            int n = Integer.parseInt(st.nextToken());
            hs.add(n);
            s = st.nextToken();
            int c = 1;
            if (s.equals("IN"))
                c = 0;
            
            list[i] = new Time(h, m, n, c);
        }
        
        Arrays.sort(list);
        
        int[] answer = new int[hs.size()];
        int sum = 0, idx = 0;
        Time t = list[0];
        for (int i = 0; i < list.length; i++) {
            Time f = list[i];
            
            if (t.n != f.n && t.c == 0) {
                sum += (23 - t.h) * 60;
                sum += 59 - t.m;
            }
    
            if (t.n == f.n && t.c == 0 && f.c == 1) {
                sum += (f.h - t.h) * 60;
                sum += f.m - t.m;
            }
            
            if (t.n != f.n) {
                answer[idx] = fees[1];
                
                if (sum > fees[0]) {
                    sum -= fees[0];
                    answer[idx] += (sum / fees[2]) * fees[3];
                    if (sum % fees[2] != 0)
                        answer[idx] += fees[3];
                }
                idx++;
                sum = 0;
            }
            
            if (i == list.length - 1 && f.c == 0) {
                sum += (23 - f.h) * 60;
                sum += 59 - f.m;
            }
            
            if (i == list.length - 1) {
                answer[idx] = fees[1];
                
                if (sum > fees[0]) {
                    sum -= fees[0];
                    answer[idx] += (sum / fees[2]) * fees[3];
                    if (sum % fees[2] != 0)
                        answer[idx] += fees[3];
                }
                idx++;
                sum = 0;
            }
            
            t = f;
        }
        
        return answer;
    }
}
class Time implements Comparable<Time> {
    int h, m, n, c; // 시간, 분, 차번호, 출차여부(in(0), out (1))
    
    public Time(int h, int m, int n, int c) {
        this.h = h;
        this.m = m;
        this.n = n;
        this.c = c;
    }
    
    @Override
    public int compareTo(Time o) {
        if (this.n == o.n) {
            if (this.h == o.h) {
                return this.m - o.m;
            }
            return this.h - o.h;
        }
        return this.n - o.n;
    }
}
