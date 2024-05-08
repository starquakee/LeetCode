public class num2079 {
    public int wateringPlants(int[] plants, int capacity) {
        int restWater = capacity;
        int ans = 0;
        int index = 0;
        while (index<plants.length){
            while (index<plants.length&&restWater>=plants[index]){
                ans++;
                restWater-=plants[index];
                index++;
            }
            if(index>=plants.length)return ans;
            ans += index+index;
            restWater = capacity;
        }
        return ans;
    }
}
