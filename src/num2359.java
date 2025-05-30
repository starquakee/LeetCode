import java.util.Arrays;

public class num2359 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int ans=Integer.MAX_VALUE;
        int res=-1;
        int[] dis1=new int[n];
        int[] dis2=new int[n];
        Arrays.fill(dis1,Integer.MAX_VALUE);
        Arrays.fill(dis2,Integer.MAX_VALUE);
        dis1[node1]=0;
        dis2[node2]=0;
        int next=edges[node1];
        int distance=0;
        while (next!=-1&&dis1[next]==Integer.MAX_VALUE){
            dis1[next]=++distance;
            next=edges[next];
        }
        next=edges[node2];
        distance=0;
        while (next!=-1&&dis2[next]==Integer.MAX_VALUE){
            dis2[next]=++distance;
            next=edges[next];
        }
        for(int i=0;i<n;i++){
            if(ans>Math.max(dis1[i],dis2[i])){
                ans=Math.max(dis1[i],dis2[i]);
                res=i;
            }
        }
        return res;
    }
}
