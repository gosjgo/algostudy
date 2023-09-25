import java.util.*;

class Solution {
    int[] in, answer, select, num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int max;
    
    public int[] solution(int n, int[] info) {
        in = info;
        select = new int[11];
        answer = new int[11];
        max = -1;
        
        perm(0, 0, n);
        
        int f = 0;
        for (int i = 0; i < 11; i++) {
            if (answer[i] != 0) {
                f = 1;
                break;
            }
        }
        
        if (f == 0)
            answer = new int[]{-1};
            
        return answer;
    }

    public void check() {
        int a = 0, b = 0;
        for (int i = 0; i < 11; i++) {
            if (!(in[i] == 0 && select[i] == 0)) {
                if (in[i] >= select[i])
                    a += 10 - i;
                else
                    b += 10 - i;
            }
        }
        
        if (a < b && max <= b - a) {
            int f = 0;
            if (max == b - a) {
                f = 1;
                for (int i = 10; i >= 0; i--) {
                    if (answer[i] > select[i]) {
                        f = 2;
                        break;
                    } else if (answer[i] < select[i])
                        break;
                }
            }
            if (max < b - a || f == 1) {
                answer = Arrays.copyOf(select, 11);
                max = b - a;
            }
        }
    }
    
    public void perm(int cnt, int sum, int n) {
        if (cnt == 11) {
            if(sum == n)
                check();
            return;
        }
        
        for (int i = 0; i < 11; i++) {
            select[cnt] = num[i];
            if (sum + num[i] <= n)
                perm(cnt + 1, sum + num[i], n);
            else {
                if (sum + num[i] == n)
                    check();
                return;
            }
        }
    }
}
