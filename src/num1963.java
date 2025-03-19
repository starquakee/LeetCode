public class num1963 {
    public int minSwaps(String s) {
        int[] arr = new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(i>0)arr[i]=arr[i-1];
            if(s.charAt(i)=='['){
                arr[i]++;
            }
        }
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(arr[i]+ans<i+1-arr[i]-ans){
                ans++;
            }
        }
        return ans;
    }
}
