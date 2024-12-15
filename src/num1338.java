import java.util.*;

public class num1338 {
    public int minSetSize(int[] arr) {
        if(arr.length==1)return 1;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        int count = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                count++;
            }else {
                list.add(count);
                count=1;
            }
        }
        list.add(count);
        Collections.sort(list);
        int ans = 0;
        int num = 0;
        while (num<arr.length/2){
            num += list.remove(list.size()-1);
            ans++;
        }
        return ans;
    }
}
