import java.util.*;
class Solution {
    public List<Integer> solution(int k, int[] score) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : score){
            pq.add(n);
            if(pq.size()>k) pq.poll();
            list.add(pq.peek());
        }
        return list;
    }
}