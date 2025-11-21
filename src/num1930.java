import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class num1930 {
//    public int countPalindromicSubsequence(String s) {
//        int ans=0;
//        int n=s.length();
//        int[] first=new int[26];
//        int[] last=new int[26];
//        Arrays.fill(first,-1);
//        Arrays.fill(last,-1);
//        for(int i=0;i<n;i++){
//            if(first[s.charAt(i)-'a']==-1)first[s.charAt(i)-'a']=i;
//        }
//        for(int i=n-1;i>=0;i--){
//            if(last[s.charAt(i)-'a']==-1)last[s.charAt(i)-'a']=i;
//        }
//        for(int i=0;i<26;i++){
//            if(first[i]==-1||last[i]==-1)continue;
//            if(first[i]+1>=last[i])continue;
//            Set<Character> set = new HashSet<>();
//            for(int j=first[i]+1;j<last[i];j++){
//                set.add(s.charAt(j));
//            }
//            ans+=set.size();
//        }
//        return ans;
//    }
    public int countPalindromicSubsequence(String s) {
        int ans=0;
        int n=s.length();
        for(char c='a';c<='z';c++){
            int i=0,j=n-1;
            while (i<n&&s.charAt(i)!=c)i++;
            while (j>=0&&i<j&&s.charAt(j)!=c)j--;
            if(i<j-1){
                Set<Character> set = new HashSet<>();
                for(int k=i+1;k<j;k++){
                    set.add(s.charAt(k));
                }
                ans+=set.size();
            }
        }
        return ans;
    }
}
