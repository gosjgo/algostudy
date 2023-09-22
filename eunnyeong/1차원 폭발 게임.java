import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++)
      list.add(Integer.parseInt(br.readLine()));

    if (list.size() == 1 && m == 1)
      list = new ArrayList<>();

    while (!list.isEmpty()) {
      int t = list.get(0), cnt = 1;
      for (int i = 1; i < list.size(); i++) {
        if (t == list.get(i))
          cnt++;

        if (t != list.get(i) || i == list.size() - 1){
          if (cnt >= m) {
            int idx = 1;
            if ((t == list.get(i) && i == list.size() - 1) || m == 1) {
              idx = 0;
              if (t == list.get(i))
                cnt--;
            }
            for (int j = idx; j <= cnt; j++)
              if (i - j >= 0)
                list.set(i - j, 0);
          }
          cnt = 1;
          t = list.get(i);
        }
      }

      List<Integer> tmp = new ArrayList<>();
      for (int i = 0; i < list.size(); i++)
        if (list.get(i) != 0)
          tmp.add(list.get(i));

      if (list.size() == tmp.size()) break;

      list = new ArrayList<>();
      list.addAll(tmp);

      if (list.isEmpty()) break;
    }

    if (list.isEmpty())
      System.out.print(0);
    else {
      System.out.println(list.size());
      for (int i = 0; i < list.size(); i++)
        System.out.println(list.get(i));
    }
  }
}
