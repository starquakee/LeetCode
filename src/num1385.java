import java.util.Arrays;

public class num1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int ans=0;
        for(int i=0;i<arr1.length;i++){
            int num1=arr1[i];
            for(int j=0;j<arr2.length;j++){
                int num2=arr2[j];
                if(num2>=num1-d&&num2<=num1+d)break;
                if(num2>num1+d){
                    ans++;
                    break;
                }
                if(j==arr2.length-1)ans++;
            }
        }
        return ans;
    }
}
