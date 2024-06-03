public class num1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int count = 1;
        int[] ans = new int[num_people];
        while (candies>0){
            for(int i=0;i<num_people;i++){
                if(candies>count){
                    ans[i] += count;
                    candies -= count;
                    count++;
                }else{
                    ans[i] += candies;
                    count += candies;
                    candies = 0;
                }
            }
        }
        return ans;
    }
}
