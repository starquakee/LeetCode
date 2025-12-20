public class num944 {
    public int minDeletionSize(String[] strs) {
        int n=strs[0].length();
        int size=strs.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j+1<size;j++){
                if(strs[j].charAt(i)>strs[j+1].charAt(i)){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
