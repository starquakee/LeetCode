public class num2843 {
    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        for(int i=low;i<=high;i++){
            if(isSymmetric(i))ans++;
        }
        return ans;
    }
    public boolean isSymmetric(int n){
        String num=String.valueOf(n);
        if(num.length()%2==1)return false;
        int left=0,right=0;
        for(int i=0;i<num.length()/2;i++) left+=num.charAt(i);
        for(int i=num.length()/2;i<num.length();i++) right+=num.charAt(i);
        return left==right;
    }
}
