import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m = change(m);
        String[][] infos = new String[musicinfos.length][4];
        for (int i = 0; i < musicinfos.length; i++) {
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
            for (int j = 0; j < 4; j++) {
                infos[i][j] = st.nextToken();
                if (j == 3)
                    infos[i][j] = change(infos[i][j]);
            }
        }
        
        int[] size = new int[musicinfos.length];
        for (int i = 0; i < musicinfos.length; i++) {
            String s1 = infos[i][0];
            int h1 = calc(s1.substring(0, 2));
            int m1 = calc(s1.substring(3, 5));
            
            String s2 = infos[i][1];
            int h2 = calc(s2.substring(0, 2));
            int m2 = calc(s2.substring(3, 5));
            size[i] = ((h2 - h1) * 60) + m2 - m1;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < musicinfos.length; i++) {
            String s = cut(infos[i][3], size[i]);
            for (int j = 0; j <= s.length() - m.length(); j++)
                if (m.equals(s.substring(j, j +  m.length())))
                    list.add(i);
        }
        
        if (list.isEmpty())
            answer = "(None)";
        else if (list.size() > 1) {
            int max = 0, idx = 0;
            for (int i = 0; i < list.size(); i++) {
                int x = list.get(i);
                if (size[x] > max) {
                    max = size[x];
                    idx = x;
                }
            }
            
            answer = infos[idx][2];
        }
        else if (list.size() == 1)
            answer = infos[list.get(0)][2];
        
        return answer;
    }
    
    public String cut(String s, int n) {
        if (n <= s.length())
            return s.substring(0, n);
        else {
            String t = "";
            for (int i = 0; i < n / s.length(); i++)
                t += s;
            
            int x = n % s.length();
            if (x != 0)
                t += s.substring(0, x);
              
            return t;
        }
    }
    
    public String change(String s) {
        s = s.replace("C#", "c");
        s = s.replace("D#", "d");
        s = s.replace("F#", "f");
        s = s.replace("G#", "g");
        s = s.replace("A#", "a");
        
        return s;
    }
    
    public int calc(String s) {
        return Integer.parseInt(s);
    }
}
