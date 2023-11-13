public class num2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int ans = 0;
        int[] arr = new int[2];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                arr[1]++;
                ans = Math.max(ans,2*Math.min(arr[0],arr[1]));
            }else if(i==0||s.charAt(i-1)=='0'){
                arr[0]++;
            }else {
                arr[0] = 1;
                arr[1] = 0;
            }
        }
        return ans;
    }
}
