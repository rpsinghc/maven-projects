package com.otrs.restaurant.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.otrs.restaurant.domain.model.entity.Restaurant;
import com.otrs.restaurant.domain.repository.RestaurantRepository;


@Service("restaurantService")
public class RestaurantServiceImpl extends BaseService<Restaurant, String> implements RestaurantService{

	RestaurantRepository<Restaurant, String> restaurantRepository;
	
	public RestaurantServiceImpl(RestaurantRepository<Restaurant, String> repository) {
		super(repository);
		this.restaurantRepository = repository;
	}

	
	@Override
	public Collection<Restaurant> getAll() {
		return super.getAll();
	}


	@Override
	public void add(Restaurant restaurant) throws Exception{
		
		if(restaurantRepository.containsName(restaurant.getName())) {
			throw new Exception(String.format("Restaurant %s already exists", restaurant.getName()));
		}
		
		if(restaurant.getName() == null || restaurant.getName().trim().length() == 0) {
			throw new Exception("Restaurant name can't be empty or null");
		}
		
		super.add(restaurant);
	;
	}



	
    @Override
    public void update(Restaurant restaurant) throws Exception {
        restaurantRepository.update(restaurant);
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(String id) throws Exception {
        restaurantRepository.remove(id);
    }

    /**
     *
     * @param restaurantId
     * @return
     * @throws Exception
     */
    @Override
    public Restaurant findById(String restaurantId) throws Exception {
        return restaurantRepository.get(restaurantId);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Restaurant> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


	@Override
	public Collection<Restaurant> findByName(String name) throws Exception {
		return restaurantRepository.findByName(name);
	}
	

}
