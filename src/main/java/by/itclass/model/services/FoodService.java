package by.itclass.model.services;

import by.itclass.model.dao.FoodDao;
import by.itclass.model.entities.FoodItem;

import java.util.List;
import java.util.Objects;

public class FoodService {
    private static FoodService service;
    private FoodDao dao;

    private FoodService(){
        dao = FoodDao.getInstance();
    }

    public static FoodService getInstance(){
        if( Objects.isNull(service)){
            service = new FoodService();
        }
        return service;
    }

    public List<FoodItem> getFoodItemsByType (int foodType){
        return dao.getFoodItemsByType(foodType);
    }
}
