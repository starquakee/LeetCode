import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class FoodRatings {
    Map<String, Pair<String,Integer>> foodMap;
    Map<String, TreeSet<Pair<String,Integer>>> ratingMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap=new HashMap<>();
        ratingMap=new HashMap<>();
        int n= foods.length;
        for(int i=0;i<n;i++){
            foodMap.put(foods[i],new Pair<>(cuisines[i],ratings[i]));
            ratingMap.putIfAbsent(cuisines[i],new TreeSet<>((a,b)->{
                if(!Objects.equals(a.getValue(), b.getValue())){
                    return b.getValue()-a.getValue();
                }else return a.getKey().compareTo(b.getKey());
            }));
            ratingMap.get(cuisines[i]).add(new Pair<>(foods[i],ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine=foodMap.get(food).getKey();
        int oldRating=foodMap.get(food).getValue();
        foodMap.put(food,new Pair<>(cuisine,newRating));
        ratingMap.get(cuisine).remove(new Pair<>(food,oldRating));
        ratingMap.get(cuisine).add(new Pair<>(food,newRating));
    }

    public String highestRated(String cuisine) {
        return ratingMap.get(cuisine).first().getKey();
    }
}
