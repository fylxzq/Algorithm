package com.fy.leetcode.Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Classname FoodRatings
 * @Description TODO
 * @Date 2022/7/24 10:40
 * @Created by fy
 */
public class FoodRatings {
    Map<String,Food> nameMap = new HashMap<>();
    Map<String, PriorityQueue<Food>> ratingMap = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int len = foods.length;
        for(int i = 0; i < len; i++){
            String name = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            Food food = new Food(name, cuisine, rating);
            nameMap.put(name, food);
            PriorityQueue<Food> priorityQueue = ratingMap.getOrDefault(cuisine, new PriorityQueue<Food>((food1, food2) -> {
                if (food1.rating != food2.rating) {
                    return food2.rating - food1.rating;
                } else {
                    return food1.foodName.compareTo(food2.foodName);
                }
            }));
            priorityQueue.add(food);
            ratingMap.put(cuisine,priorityQueue);
        }
    }

    public void changeRating(String name, int newRating) {
        Food food = nameMap.get(name);
        String cuisine = food.cuisine;
        PriorityQueue<Food> priorityQueue = ratingMap.get(cuisine);
        priorityQueue.remove(food);
        food.rating = newRating;
        priorityQueue.add(food);
    }

    public String highestRated(String cuisine) {
        return ratingMap.get(cuisine).peek().foodName;
    }
}

class Food{
    String foodName;
    String cuisine;
    int rating;

    public Food(String foodName, String cuisines, int raring) {
        this.foodName = foodName;
        this.cuisine = cuisines;
        this.rating = raring;
    }
}
