import java.util.*;
class Solution {
    public int solution(String s) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<10; i++){
            if(s.contains(nums[i])) s=s.replace(nums[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}