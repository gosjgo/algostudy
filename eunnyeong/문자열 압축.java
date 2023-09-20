class Solution {
    int answer;
    
    public int solution(String s) {
        answer = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++)
            calc(s, i);
        
        return answer;
    }

    public void calc(String s, int n) {
        String ans = "", t1 = s.substring(0, n);
        int cnt = 1, i = n;
        
        for (i = n; i < s.length(); i+=n) {
            int x = i + n;
            if (x >= s.length())
                x = s.length();
                
            String t2 = s.substring(i, x);
            
            if (x >= s.length()) {
                if (t1.equals(s.substring(i,x)))
                    cnt++;
                else 
                    ans += t1;
                if (cnt > 1)
                    ans += Integer.toString(cnt);
                ans += s.substring(i, x);
                break;
            }
            
            if (t1.equals(t2))
                cnt++;
            else {
                if (cnt > 1)
                    ans += Integer.toString(cnt);
                if (x != s.length())
                    ans += t1;
                else 
                    ans += t2;
                t1 = t2;
                cnt = 1;
            }
        }
       
        answer = Math.min(ans.length(), answer);
    }
}
