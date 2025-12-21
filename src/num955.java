import java.util.Arrays;

public class num955 {
    public int minDeletionSize(String[] strs) {
        int ans=0;
        int n=strs.length;
        int l=strs[0].length();
        String[] temp = new String[n];
        for(int i=0;i<l;i++){
            String[] temp2 = Arrays.copyOf(temp, n);
            for(int j=0;j<n;j++){
                temp2[j]+=strs[j].charAt(i);
            }
            if(isSorted(temp2)){
                temp=temp2;
            }else ans++;
        }
        return ans;
    }
    public boolean isSorted(String[] strs){
        boolean ans=true;
        for(int i=1;i<strs.length;i++){
            if(strs[i-1].compareTo(strs[i])>0)return false;
        }
        return true;
    }
}
