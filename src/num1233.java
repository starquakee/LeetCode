import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num1233 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans=new ArrayList<>();
        ans.add(folder[0]);
        for(int i=1;i< folder.length;i++){
            String preString= ans.get(ans.size()-1);
            if(!(preString.length()<folder[i].length()&&folder[i].startsWith(preString+"/"))){
                ans.add(folder[i]);
            }
        }
        return ans;
    }
}
