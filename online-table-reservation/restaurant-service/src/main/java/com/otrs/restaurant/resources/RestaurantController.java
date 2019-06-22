package com.otrs.restaurant.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otrs.restaurant.domain.model.entity.Restaurant;
import com.otrs.restaurant.domain.service.RestaurantService;
import com.otrs.restaurant.domain.valueobject.RestaurantVO;


@RestController
@RequestMapping("/v1/restaurants")
public class RestaurantController {
	protected static final Logger logger = Logger.getLogger(RestaurantController.class.getName());

	protected RestaurantService restaurantService;

	@Autowired
	public RestaurantController(RestaurantService restaurantService) {
		super();
		this.restaurantService = restaurantService;
	}
	
	@GetMapping("/{restaurant-id}")
	public ResponseEntity<Restaurant> findById(@PathVariable("restaurant-id") String id){
		Restaurant restaurant= null;
		try {
			restaurant  = restaurantService.findById(id);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e) {
			
		}
		return restaurant != null ? new ResponseEntity<Restaurant>(restaurant,HttpStatus.OK): new ResponseEntity<Restaurant>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping("/{restaurant-id}")
	public ResponseEntity<Restaurant> findByName(@RequestParam("name") String id){
		Restaurant restaurant = null;
		try {
			restaurant  = restaurantService.findById(id);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e) {
			
		}
		return restaurant != null ? new ResponseEntity<Restaurant>(restaurant,HttpStatus.OK): new ResponseEntity<Restaurant>(HttpStatus.NO_CONTENT);
	}
	
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Restaurant> add(@RequestBody RestaurantVO restaurantVO) {
        logger.info(String.format("restaurant-service add() invoked: %s for %s", restaurantService.getClass().getName(), restaurantVO.getName()));
        System.out.println(restaurantVO);
        Restaurant restaurant = new Restaurant(null, null, null, null);
        BeanUtils.copyProperties(restaurantVO, restaurant);
        try {
            restaurantService.add(restaurant);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
}
