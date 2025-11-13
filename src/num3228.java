public class num3228 {
    public int maxOperations(String s) {
        int ans=0;
        int n=s.length();
        int i=0;
        int temp=0;
        while (i<n){
            while (i<n&&s.charAt(i)=='1'){
                temp++;
                i++;
            }
            if(i<n){
                while (i<n&&s.charAt(i)=='0'){
                    i++;
                }
                ans+=temp;
            }
        }
        return ans;
    }
}
