import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(arr[0]);
        for(int n : arr) {
            if(stack.peek() != n) stack.push(n);
        }
        int[] result = new int[stack.size()];
        for(int i=0; i<result.length; i++) {
            result[i] = stack.pollLast();
        }

        return result;
    }
}