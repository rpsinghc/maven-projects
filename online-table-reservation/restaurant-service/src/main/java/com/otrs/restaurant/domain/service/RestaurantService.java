package com.otrs.restaurant.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.otrs.restaurant.domain.model.entity.Restaurant;

public interface RestaurantService {

    /**
     *
     * @param restaurant
     * @throws Exception
     */
    public void add(Restaurant restaurant) throws Exception;

    /**
     *
     * @param restaurant
     * @throws Exception
     */
    public void update(Restaurant restaurant) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception;

    /**
     *
     * @param restaurantId
     * @return
     * @throws Exception
     */
    public Restaurant findById(String restaurantId) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Restaurant> findByName(String name) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Restaurant> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
