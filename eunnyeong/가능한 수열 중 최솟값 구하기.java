import java.util.*;
import java.io.*;

public class Main {

  static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    dfs("");
  }

  public static boolean check(String s) {
    for (int i = 1; i < s.length(); i++) {

      int idx = i;
      while (true){
        if (idx + i > s.length()) break;

        String t1 = s.substring(idx - i, idx);
        String t2 = s.substring(idx, idx + i);
        if (t1.equals(t2)) return false;
        idx++;
      }
    }
    return true;
  }

  public static void dfs(String s) {
    String[] str= {"4", "5", "6"};
    
    if (s.length() > n || !check(s)) return;
    if (s.length() == n) {
      System.out.print(s);
      System.exit(0);
    }

    for (int i = 0; i < 3; i++)
      dfs(s + str[i]);
  }
}
