public class num1758 {
    public int minOperations(String s) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<2;i++){
            int temp=0;
            int t=i;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)-'0'!=t){
                    temp++;
                }
                t=1-t;
            }
            ans=Math.min(ans, temp);
        }
        return ans;
    }
}
