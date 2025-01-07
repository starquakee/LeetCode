public class num3019 {
    public int countKeyChanges(String s) {
        int ans = 0;
        for(int i=1;i<s.length();i++){
            if(Math.abs(s.charAt(i)-s.charAt(i-1))!=Math.abs('a'-'A')){
                if(s.charAt(i)-s.charAt(i-1)!=0){
                    ans++;
                }
            }
        }
        return ans;
    }
}
