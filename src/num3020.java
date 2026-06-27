import java.util.*;

public class num3020 {
    public int maximumLength(int[] nums) {
        Set<Integer> once = new HashSet<>();
        Set<Integer> twice = new HashSet<>();
        for (int num : nums) {
            if (once.contains(num)) {
                twice.add(num);
            } else {
                once.add(num);
            }
        }
        List<Integer> unique = new ArrayList<>();
        unique.addAll(twice);
        Collections.sort(unique);
        int ans=1;
        for(int i=0;i<unique.size();i++){
            int temp=2;
            int base = unique.get(i);
            if(base==1){
                int count=0;
                for (int num : nums) {
                    if (num == 1) {
                        count++;
                    }
                }
                if(count%2==0){
                    count--;
                }
                ans = Math.max(ans,count);
            }else {
                while (true){
                    if(once.contains((int)Math.pow(base,2))){
                        temp++;
                    }else {
                        ans = Math.max(ans,temp-1);
                        break;
                    }
                    if(twice.contains((int)Math.pow(base,2))){
                        temp++;
                    }else {
                        ans = Math.max(ans,temp);
                        break;
                    }
                    base = (int)Math.pow(base,2);
                }
            }
        }
        return ans;
    }
}
