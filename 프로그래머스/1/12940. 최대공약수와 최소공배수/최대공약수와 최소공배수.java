class Solution {
    public int[] solution(int n, int m) {
        int g = gcd(n,m);
        int l = n * m / g;
        return new int[] {g, l};
    }
    static int gcd(int a, int b) {
        while(b != 0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}