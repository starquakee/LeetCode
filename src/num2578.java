import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class num2578 {
    public int splitNum(int num) {
        List<Integer> list = new ArrayList<>();
        while (num>0){
            list.add(num%10);
            num /= 10;
        }
        int size = list.size();
        int ans = 0;
        Collections.sort(list);
        if(size%2==0){
            for(int i=0;i<size/2;i++){
                ans += (int) (list.get(2*i)*Math.pow(10,size/2-1-i));
                ans += (int) (list.get(2*i+1)*Math.pow(10,size/2-1-i));
            }
        }else {
            ans += (int) (list.get(0)*Math.pow(10,size/2));
            for(int i=0;i<size/2;i++){
                ans += (int) (list.get(2*i+1)*Math.pow(10,size/2-1-i));
                ans += (int) (list.get(2*i+2)*Math.pow(10,size/2-1-i));
            }
        }
        return ans;
    }
}
