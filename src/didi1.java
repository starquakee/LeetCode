import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class didi1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        st.parseNumbers();
        st.nextToken();
        int N=(int)st.nval;
        int[] W=new int[N],A=new int[N],B=new int[N];
        int maxW=0;
        long totalB=0;
        for(int i=0;i<N;i++){
            st.nextToken();W[i]=(int)st.nval;
            st.nextToken();A[i]=(int)st.nval;
            st.nextToken();B[i]=(int)st.nval;
            if(W[i]>maxW) maxW=W[i];
            totalB+=B[i];
        }
        st.nextToken();
        int Q=(int)st.nval;
        StringBuilder sb=new StringBuilder();
        while (Q-->0){
            st.nextToken();
            long x=(long)st.nval;
            if(x-totalB>maxW){
                sb.append(x-totalB).append('\n');
                continue;
            }
            for(int i=0;i<N;i++){
                if(x>W[i]){
                    x=Math.max(0,x-B[i]);
                }else {
                    x+=A[i];
                }
            }
            sb.append(x).append('\n');
        }
        System.out.println(sb);
    }
}
