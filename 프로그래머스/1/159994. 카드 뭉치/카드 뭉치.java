import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> q1 = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> q2 = new ArrayDeque<>(Arrays.asList(cards2));
        for(int i=0; i<goal.length; i++){
            String str = goal[i];
            if(!q1.isEmpty() && str.equals(q1.peek())){
                q1.poll();
            }else if(!q2.isEmpty() && str.equals(q2.peek())){
                q2.poll();
            }else{
                answer = "No";
                break;
            }
        }
        return answer;
    }
}