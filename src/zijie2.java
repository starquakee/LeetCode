//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Z {
//    public static void main(String[] args) {
//        Scanner input =new Scanner(System.in);
//        int n=input.nextInt();
//        List<Integer> arr = new ArrayList<>();
//        for(int i=0;i<n;i++){
//            arr.add(input.nextInt());
//        }
//        int[] leftMin=new int[n];
//        int[] rightMax=new int[n];
//        leftMin[0]=Integer.MAX_VALUE;
//        rightMax[n-1]=Integer.MIN_VALUE;
//        for(int i=1;i<n;i++){
//            leftMin[i]=Math.min(leftMin[i-1],arr.get(i-1));
//        }
//        for(int i=n-2;i>=0;i--){
//            rightMax[i]=Math.max(rightMax[i+1], arr.get(i+1));
//        }
//        System.out.println(cal(arr,0,n-1));
//    }
//    public static int cal(List<Integer> list,int left,int right){
//        for(int mid=left+1;mid<right)
//    }
//}
