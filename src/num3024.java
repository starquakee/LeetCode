public class num3024 {
    public String triangleType(int[] nums) {
        int len1=nums[0];
        int len2=nums[1];
        int len3=nums[2];
        if(len1==len2&&len2==len3){
            return "equilateral";
        }
        if(len1+len2>len3&&len1+len3>len2&&len2+len3>len1){
            if(len1==len2||len2==len3||len1==len3)return "isosceles";
            else return "scalene";
        }else return "none";
    }
}
