import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(long n) {
        String str = n + "";
        int[] arr = new int[str.length()];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(str.substring(arr.length-i-1,arr.length-i));
        }
        return arr;
    }
}