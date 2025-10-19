public class num2011 {
    public int finalValueAfterOperations(String[] operations) {
        int ans=0;
        for(String s:operations){
            if(s.contains("+")){
                ans++;
            }else {
                ans--;
            }
        }
        return ans;
    }
}
