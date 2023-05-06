import java.util.*;

public class xiecheng2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] a=new String[n];
        for(int i=0;i<n;i++){
            a[i]=input.next();
            a[i]+="&#%@";
            a[i]+=input.next();
        }
//        Arrays.sort(a);
        int ans=-8888888;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(a[i].split("&#%@")[0].contains(a[j].split("&#%@")[0])){
                        ans=Math.max(ans,Integer.parseInt(a[i].split("&#%@")[1])+Integer.parseInt(a[j].split("&#%@")[1]));
//                        System.out.println(Integer.parseInt(a[i].split("&#%@")[1])+"  "+Integer.parseInt(a[j].split("&#%@")[1]));
                    }
                }
            }
        }
        if(ans==-8888888){
            ans=-1;
        }
        System.out.println(ans);
    }
}
