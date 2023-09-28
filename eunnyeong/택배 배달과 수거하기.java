import java.util.Stack;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> ds = new Stack<>();
        Stack<Integer> ps = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < deliveries[i]; j++)
                ds.push(i + 1);
            for (int j = 0; j < pickups[i]; j++)
                ps.push(i + 1);
        }
        
        while (!ds.isEmpty() && !ps.isEmpty()) {
            int d = ds.peek(), p = ps.peek();
            for (int i = 0; i < cap; i++) {
                if (!ds.isEmpty()) ds.pop();
                if (!ps.isEmpty()) ps.pop();
            }
            answer += Math.max(d, p) * 2;
        }
        
        while (!ds.isEmpty()) {
            int d = ds.peek();
            for (int i = 0; i < cap; i++)
                if (!ds.isEmpty()) ds.pop();
              
            answer += d * 2;
        }
        
         while (!ps.isEmpty()) {
            int p = ps.peek();
            for (int i = 0; i < cap; i++)
                if (!ps.isEmpty()) ps.pop();
              
            answer += p * 2;
        }
        
        return answer;
    }
}
