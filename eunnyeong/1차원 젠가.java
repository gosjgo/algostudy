import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < n; i++)
      list.add(Integer.parseInt(br.readLine()));

    for (int i = 0; i < 2; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;

      for (int j = x; j <= y; j++)
        list.remove(x);
    }
    
    if (list.isEmpty())
      System.out.print(0);
    else {
      System.out.println(list.size());
      for (Integer i : list)
        System.out.println(i);
    }
  }
}
