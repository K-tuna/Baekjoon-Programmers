class Solution {
    public int solution(int a, int b, int n) {
        int sum = 0;
        while(n>=a){
            int get = n/a*b;
            n = get + n%a;
            sum += get;
        }
        return sum;
    }
}