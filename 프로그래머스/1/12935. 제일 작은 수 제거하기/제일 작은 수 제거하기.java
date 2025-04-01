import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        ArrayList<Integer> olist = new ArrayList<>();
        for(int n : arr){
            olist.add(n);
        }
        ArrayList<Integer> slist = new ArrayList<>(olist);
        slist.sort((a,b) -> b-a);
        int min = slist.get(arr.length-1);
        for(int i=0; i<arr.length; i++){
            if(olist.get(i) == min) {
                olist.remove(i);
                break;
            }
        }
        for(int i=0; i<arr.length-1; i++){
            answer[i] = olist.get(i);
        }
        return arr.length==1 ? new int[]{-1} : answer;
    }
}