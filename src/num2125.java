public class num2125 {
    public int numberOfBeams(String[] bank) {
        int n=bank.length;
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<bank[i].length();j++){
                if(bank[i].charAt(j)=='1') nums[i]++;
            }
        }
        int ans=0;
        int pre=0;
        for(int i=0;i<n;i++){
            ans+=pre*nums[i];
            if(nums[i]>0) pre=nums[i];
        }
        return ans;
    }
}
