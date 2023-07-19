import java.util.ArrayList;
import java.util.List;

public class num42 {
    public static int trap(int[] height) {
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i+1<height.length){
            if(height[i]==height[i+1]){
                i++;
            }else break;
        }
        if(i==height.length-1) return 0;
        if(height[i]>height[i+1]){
            list.add(i);
        }
        i++;
        while (i<height.length){
            if(height[i]>height[i-1]){
                while (i+1<height.length){
                    if(height[i]==height[i+1]){
                        i++;
                    }else break;
                }
                if(i<height.length-1){
                    if(height[i]>height[i+1]){
                        if(list.size()>1){
                            if(height[list.get(list.size()-1)]<height[list.get(list.size()-2)]&&height[list.get(list.size()-1)]<height[i]){
                                list.remove(list.size()-1);
                                list.add(i);
                            }else list.add(i);
                        }else list.add(i);

                    }
                }else{
                    if(list.size()>1){
                        if(height[list.get(list.size()-1)]<height[list.get(list.size()-2)]&&height[list.get(list.size()-1)]<height[i]){
                            list.remove(list.size()-1);
                            list.add(i);
                        }else list.add(i);
                    }else list.add(i);
                }

            }
            i++;
        }
        System.out.println(list);
        for(int j=0;j<list.size()-1;j++){
            int minHeight = Math.min(height[list.get(j)],height[list.get(j+1)]);
            ans += (list.get(j+1)-list.get(j)-1)*minHeight;
            System.out.println((list.get(j+1)-list.get(j)-1)*minHeight);
            for(int k=list.get(j)+1;k<list.get(j+1);k++){
                ans -= Math.min(height[k],minHeight);
                System.out.println(-Math.min(height[k],minHeight));
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        trap(height);
    }
}

