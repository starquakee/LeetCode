import java.util.Arrays;

public class num1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length;
        int l=1,r=position[n-1];
        int ans=1;
        while (l<=r){
            int mid=(l+r)/2;
            if(check(position,m,mid)){
                ans=Math.max(ans,mid);
                l=mid+1;
            }else r=mid-1;
        }
        return ans;
    }
    public boolean check(int[] position, int m, int ans){
        int start=position[0];
        int count=0;
        for(int i=0;i<position.length;i++){
            if(start<=position[i]){
                start=position[i]+ans;
                count++;
            }
        }
        return count>=m;
    }
}
