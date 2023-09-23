import java.util.Scanner;

public class xiaomi21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int m = Integer.parseInt(s.split(",")[0]);
        int n = Integer.parseInt(s.split(",")[1]);
        int[][] arr = new int[m][2];
        int[] q = new int[m];
        for(int i=0;i<m;i++){
            s = input.nextLine();
            arr[i][0] = Integer.parseInt(s.split(",")[0]);
            arr[i][1] = Integer.parseInt(s.split(",")[1]);
            q[i] = Integer.parseInt(s.split(",")[2]);
        }
        int ans = 0;
        double max = 0;
        for(int i=0;i<m;i++){
            int num = 0;
            for(int j=0;j<m;j++){
                double distance = Math.sqrt(Math.pow(arr[i][0]-arr[j][0],2)+Math.pow(arr[i][1]-arr[j][1],2));
                if(distance<=n){
                    num += q[j]/(1+distance);
                }
            }
            if(num>max){
                max = num;
                ans = i;
            }else if(num==max){
                if(arr[i][0]<arr[ans][0]){
                    max = num;
                    ans = i;
                } else if (arr[i][0] == arr[ans][0] && arr[i][1] < arr[ans][1]) {
                    max = num;
                    ans = i;
                }
            }
        }
        System.out.println(arr[ans][0]+","+arr[ans][1]);
    }
}
