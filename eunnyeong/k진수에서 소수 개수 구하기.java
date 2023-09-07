import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String s = Integer.toString(n, k);
        StringTokenizer st = new StringTokenizer(s, "0");
        
        while(st.hasMoreTokens()) {
            long x = Long.parseLong(st.nextToken());
            
            if (x == 1)
                continue;
            
            int f = 0;
            if (x == 2 || x == 3)
                f = 0;
            else if (x % 2 == 0 || x % 3 == 0)
                f = 1;
            else {
                for (int i = 5; i <= Math.sqrt(x); i++) {
                    if (x % i == 0) {
                        f = 1;
                        break;
                    }
                }
            }
            
            if (f == 0)
                answer++;
        }
        
        return answer;
    }
}
