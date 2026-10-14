public class num3723 {
    public String maxSumOfSquares(int num, int sum) {
        if(num*9<sum)return "";
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<num;i++){
            if(sum>9){
                ans.append(9);
                sum-=9;
            }else {
                ans.append(sum);
                sum=0;
            }
        }
        return ans.toString();
    }
}
