public class num3453 {
    public double separateSquares(int[][] squares) {
        double ans=0;
        double l=0;
        double r= 1e9;
        while (l<=r){
            double mid=(l+r)/2;
            double up=calUp(squares,mid);
            double down=calDown(squares,mid);
            if(Math.abs(mid-ans)<5e-6)return ans;
            if(up>down){
                l=mid;
                ans=l;
            }
            else {
                r=mid;
                ans=r;
            }
        }
        return ans;
    }
    public double calUp(int[][] squares,double l){
        double area=0;
        for(int[] square:squares){
            if(square[1]+square[2]>l){
                area+=(Math.min(square[1]+square[2]-l,square[2]))*square[2];
            }
        }
        return area;
    }
    public double calDown(int[][] squares,double l){
        double area=0;
        for(int[] square:squares){
            if(square[1]<l){
                area+=(Math.min(l-square[1],square[2]))*square[2];
            }
        }
        return area;
    }
}
