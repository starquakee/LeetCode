import java.util.ArrayList;
import java.util.List;

public class num3170 {
    public String clearStars(String s) {
        List<Integer>[] list = new ArrayList[26];
        for(int i=0;i<26;i++){
            list[i]=new ArrayList<>();
        }
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!='*'){
                list[arr[i]-'a'].add(i);
            }else {
                for(int j=0;j<26;j++){
                    if(!list[j].isEmpty()){
                        arr[list[j].get(list[j].size()-1)]='*';
                        list[j].remove(list[j].size()-1);
                        break;
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!='*'){
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
