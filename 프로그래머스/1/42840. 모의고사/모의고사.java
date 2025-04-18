import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] scores = {0,0,0};
        int[] first =  {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third =  {3,3,1,1,2,2,4,4,5,5};
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<answers.length; i++){
            if(answers[i]==first[i%5]) scores[0]++;
            if(answers[i]==second[i%8]) scores[1]++;
            if(answers[i]==third[i%10]) scores[2]++;
        }
        int max = Math.max(Math.max(scores[0],scores[1]), scores[2]);
        for(int i=0; i<3; i++){
            if(scores[i]==max) list.add(i+1);
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i]=list.get(i);
        }
        return result;
    }
}