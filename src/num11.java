public class num11 {
//    public  static int maxArea(int[] height) {
//        int max = 0;
//        int left_max = 0;
//        for(int i=0;i<height.length;i++){
//            if (height[i]>left_max){
//                left_max = height[i];
//                int max_height = 0;
//                for(int j=height.length-1;j>i;j--){
//                    if(height[j]>max_height){
//                        max_height = height[j];
//                        max = Math.max(max, (j-i) * Math.min(height[i], max_height));
//                    }
//                }
//            }
//
//        }
//        return max;
//    }
    public int maxArea(int[] height) {
        int ans=0;
        int leftMax=0;
        for(int i=0;i<height.length-1;i++){
            if(height[i]>leftMax){
                leftMax=height[i];
                int rightMax=0;
                for(int j=height.length-1;j>i;j--){
                    if(height[j]>rightMax){
                        rightMax=height[j];
                        ans=Math.max(ans,Math.min(leftMax,rightMax)*(j-i));
                    }
                }
            }
        }
        return ans;
    }
}
