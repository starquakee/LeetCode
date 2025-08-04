import java.util.HashSet;
import java.util.Set;

public class num904 {
    public int totalFruit(int[] fruits) {
        int ans=0;
        int nextIndex=0;
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<fruits.length;){
            set.clear();
            set.add(fruits[i]);
            int j=i+1;
            while (j<fruits.length&&(set.size()<2||set.contains(fruits[j]))){
                if(j>0&&fruits[j]!=fruits[j-1]){
                    nextIndex=j;
                }
                set.add(fruits[j]);
                j++;
            }
            ans=Math.max(ans,j-i);
            if(j==fruits.length){return ans;}
            i=nextIndex;
        }
        return ans;
    }
}
