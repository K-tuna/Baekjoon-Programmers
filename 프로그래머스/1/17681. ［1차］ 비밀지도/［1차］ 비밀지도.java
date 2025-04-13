class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];
        String[] str1 = new String[n];
        String[] str2 = new String[n];
        for(int i=0; i<n; i++){
            str1[i] = String.format("%" + n + "s",Integer.toBinaryString(arr1[i])).replace(" ","0");
            str2[i] = String.format("%" + n + "s",Integer.toBinaryString(arr2[i])).replace(" ","0");
        }
        for(int i=0; i<n; i++){
            String str = "";
            for(int j=0; j<n; j++){
                if(str1[i].charAt(j)=='0' && str2[i].charAt(j)=='0') str += " ";
                else str += "#";
            }
            map[i] = str;
        }
        return map;
    }
}