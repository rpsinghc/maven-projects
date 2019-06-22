package com.otrs.resturant;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.otrs.restaurant.domain.model.entity.Restaurant;
import com.otrs.restaurant.domain.repository.RestaurantRepository;

@Repository("restaurantRepository")
public class InMemoryRestaurantRepository implements RestaurantRepository<Restaurant, String>{
	
	Map<String,Restaurant> entities;

    public InMemoryRestaurantRepository() {
        entities = new HashMap<String,Restaurant>();
        Restaurant restaurant = new Restaurant("Le Meurice", "1", "228 rue de Rivoli, 75001, Paris", null);
        entities.put("1", restaurant);
        restaurant = new Restaurant("L'Ambroisie", "2", "9 place des Vosges, 75004, Paris", null);
        entities.put("2", restaurant);
        restaurant = new Restaurant("Arpège", "3", "84, rue de Varenne, 75007, Paris", null);
        entities.put("3", restaurant);
        restaurant = new Restaurant("Alain Ducasse au Plaza Athénée", "4", "25 avenue de Montaigne, 75008, Paris", null);
        entities.put("4", restaurant);
        restaurant = new Restaurant("Pavillon LeDoyen", "5", "1, avenue Dutuit, 75008, Paris", null);
        entities.put("5", restaurant);
        restaurant = new Restaurant("Pierre Gagnaire", "6", "6, rue Balzac, 75008, Paris", null);
        entities.put("6", restaurant);
        restaurant = new Restaurant("L'Astrance", "7", "4, rue Beethoven, 75016, Paris", null);
        entities.put("7", restaurant);
        restaurant = new Restaurant("Pré Catelan", "8", "Bois de Boulogne, 75016, Paris", null);
        entities.put("8", restaurant);
        restaurant = new Restaurant("Guy Savoy", "9", "18 rue Troyon, 75017, Paris", null);
        entities.put("9", restaurant);
        restaurant = new Restaurant("Le Bristol", "10", "112, rue du Faubourg St Honoré, 8th arrondissement, Paris", null);
        entities.put("10", restaurant);
    }
	
	@Override
	public void update(Restaurant entity) {
		if(entities.containsKey(entity.getName())){
			entities.put(entity.getName(),entity);
		}
		
	}

	@Override
	public void add(Restaurant entity) {
		entities.put(entity.getName(),entity);
		
	}

	@Override
	public void remove(String id) {
		if(entities.containsKey(id)) {
			entities.remove(id);
		}
		
	}

	@Override
	public boolean containsId(String id) {
		
		return entities.containsKey(id);
	}

	@Override
	public Collection<Restaurant> getAll() {
		return entities.values();
	}

	@Override
	public boolean containsName(String name) {
		return entities.containsKey(name);
	}

	@Override
	public Restaurant get(String id) {
		return entities.get(id);
	}

	@Override
	public Collection<Restaurant> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
