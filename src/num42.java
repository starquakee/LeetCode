import java.util.*;

public class num42 {
//    public static int trap(int[] height) {
//        int ans = 0;
//        List<Integer> list = new ArrayList<>();
//        int i = 0;
//        while (i+1<height.length){
//            if(height[i]==height[i+1]){
//                i++;
//            }else break;
//        }
//        if(i==height.length-1) return 0;
//        if(height[i]>height[i+1]){
//            list.add(i);
//        }
//        i++;
//        while (i<height.length){
//            if(height[i]>height[i-1]){
//                while (i+1<height.length){
//                    if(height[i]==height[i+1]){
//                        i++;
//                    }else break;
//                }
//                if(i<height.length-1){
//                    if(height[i]>height[i+1]){
//                        if(list.size()>1){
//                            if(height[list.get(list.size()-1)]<height[list.get(list.size()-2)]&&height[list.get(list.size()-1)]<height[i]){
//                                list.remove(list.size()-1);
//                                list.add(i);
//                            }else list.add(i);
//                        }else list.add(i);
//
//                    }
//                }else{
//                    if(list.size()>1){
//                        if(height[list.get(list.size()-1)]<height[list.get(list.size()-2)]&&height[list.get(list.size()-1)]<height[i]){
//                            list.remove(list.size()-1);
//                            list.add(i);
//                        }else list.add(i);
//                    }else list.add(i);
//                }
//
//            }
//            i++;
//        }
//        System.out.println(list);
//        for(int j=0;j<list.size()-1;j++){
//            int minHeight = Math.min(height[list.get(j)],height[list.get(j+1)]);
//            ans += (list.get(j+1)-list.get(j)-1)*minHeight;
//            System.out.println((list.get(j+1)-list.get(j)-1)*minHeight);
//            for(int k=list.get(j)+1;k<list.get(j+1);k++){
//                ans -= Math.min(height[k],minHeight);
//                System.out.println(-Math.min(height[k],minHeight));
//            }
//        }
//        return ans;
//    }
//    public int trap(int[] height) {
//        int n = height.length;
//        if (n == 0) {
//            return 0;
//        }
//
//        int[] leftMax = new int[n];
//        leftMax[0] = height[0];
//        for (int i = 1; i < n; ++i) {
//            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
//        }
//
//        int[] rightMax = new int[n];
//        rightMax[n - 1] = height[n - 1];
//        for (int i = n - 2; i >= 0; --i) {
//            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
//        }
//
//        int ans = 0;
//        for (int i = 0; i < n; ++i) {
//            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
//        }
//        return ans;
//    }
    public int trap(int[] height) {
        int n=height.length;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i-1]);
            rightMax[n-i-1]=Math.max(rightMax[n-i],height[n-i]);
        }
        int ans=0;
        for(int i=1;i<n-1;i++){
            ans+=Math.max(Math.min(leftMax[i],rightMax[i])-height[i],0);
        }
        return ans;
    }
}

