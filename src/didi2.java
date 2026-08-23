import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class didi2 {
    static int n,m;
    static int[][] a;
    static long ans=Long.MIN_VALUE;
    public static void helper(){
        for(int top=0;top<n;top++){
            long[] col=new long[m];
            for(int bot=top;bot<n;bot++){
                int h=bot-top+1;
                for(int j=0;j<m;j++)col[j]+=a[bot][j];
                long best=Long.MIN_VALUE,minPre=0;
                long[] preArr=new long[m+1];
                for(int j=0;j<m;j++)preArr[j+1]=preArr[j]+col[j];
                for(int r=h;r<=m;r++){
                    if(preArr[r-h]<minPre)minPre=preArr[r-h];
                    best=Math.max(best,preArr[r]-minPre);
                }
                ans=Math.max(ans,best*h);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] nm=br.readLine().trim().split("\\s+");
        n=Integer.parseInt(nm[0]);
        m=Integer.parseInt(nm[1]);
        a=new int[n][m];
        for(int i=0;i<n;i++){
            String[] parts=br.readLine().trim().split("\\s+");
            for(int j=0;j<m;j++){
                a[i][j]=Integer.parseInt(parts[j]);
            }
        }
        helper();
        int[][] b=new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                b[j][i]=a[i][j];
            }
        }
        a=b;
        int t=n;n=m;m=t;
        helper();
        System.out.println(ans);
    }
}
