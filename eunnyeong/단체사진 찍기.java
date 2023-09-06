class Solution {
    
    char[] name = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'}, select;
    int ans;
    boolean[] visit;
    
    public int solution(int n, String[] data) {
        ans = 0;
        select = new char[8];
        visit = new boolean[8];
        
        perm(0, data);
        
        return ans;
    }
    
    public boolean check(String s) {
        char a = s.charAt(0);
        char b = s.charAt(2);
        char x = s.charAt(3);
        int n = s.charAt(4) - '0';
        
        int cnt = 0, f = 0;
        for (int i = 0; i < 8; i++) {
            if (select[i] == a || select[i] == b) {
                if (f == 1)
                    break;
                else if (f == 0)
                    f = 1;
            }
            
            if (f == 1)
                cnt++;
        }
        
        cnt--;
        
        if ((x == '=' && cnt == n) || (x == '<' && cnt < n) || (x == '>' && cnt > n))
            return true;
        
        return false;
            
    }
    
    public void perm(int cnt, String[] data) {
        if (cnt == 8) {
            int c = 0;
            for (int i = 0; i < data.length; i++)
                if (check(data[i]))
                    c++;
                else
                    return;
            
            if (c == data.length)
                ans++;
            
            return;
        }
        
        for (int i = 0; i < 8; i++) {
            if (!visit[i]) {
                select[cnt] = name[i];
                visit[i] = true;
                perm(cnt + 1, data);
                visit[i] = false;
            }
        }
    }
}
