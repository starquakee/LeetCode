import java.util.Scanner;

public class rongyao25_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        String[] a=new String[n];
        String[] b=new String[n];
        in.nextLine();
        for(int i=0;i<n;i++){
            a[i]=in.nextLine();
        }
        for(int i=0;i<n;i++){
            b[i]=in.nextLine();
        }
        System.out.println(solve(a,b));
    }
    public static int solve(String[] arrA,String[] arrB){
        int ans=0;
        int count=arrA.length;
        for(int c=0;c<count;c++){
            String a=arrA[c];
            String b=arrB[c];
            if(a.length()<b.length()){
                String temp=b;
                b=a;
                a=temp;
            }
            System.out.println(a);
            System.out.println(b);
            int aLen=a.length();
            int bLen=b.length();
            int[] left=new int[bLen+1];
            for(int i=0;i<=bLen;i++)left[i]=i;
            for(int i=1;i<=aLen;i++){
                int[] curr=new int[bLen+1];
                curr[0]=i;
                char chara=a.charAt(i-1);
                for(int j=1;j<=bLen;j++){
                    int temp=1;
                    if(chara==b.charAt(j-1)){
                        temp=0;
                    }
                    int delete=left[j]+1;
                    int add=curr[j-1]+1;
                    int replace=left[j-1]+temp;
                    curr[j]=Math.min(delete,Math.min(add,replace));
                }
                left=curr;
            }
            System.out.println(left[bLen]);
            ans+=left[bLen];
        }
        return ans;
    }
}
