class Solution {
    static int n,r = 3,cnt = 0;
    static int[] arr,output;
    public int solution(int[] nums) {
        Solution.arr=nums;
        n = nums.length;
        output = new int[r];
        comb(0,0);
        return cnt;
    }
    static void comb(int start, int depth){
        if(depth == r){
            int sum = 0;
            for(int o : output) {
                sum += o;
            }
            if(isPrime(sum)) cnt ++;
            return;
        }
        for(int i=start; i<n; i++){
            output[depth] = arr[i];
            comb(i+1, depth+1);
        }
    }
    
    static boolean isPrime(int n){
        if(n < 2) return false;
        for(int i=2; i*i<=n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
}