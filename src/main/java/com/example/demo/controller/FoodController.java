package com.example.demo.controller;

import com.example.demo.repo.OrderRepository;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Food;
import com.example.demo.model.Order;
import com.example.demo.repo.FoodRepository;

@CrossOrigin(origins = "https://spice-delight-restaurant-rho.vercel.app", allowCredentials = "true")
@RestController
@RequestMapping("/api/orders") 
public class FoodController {

    private final OrderRepository orderRepository;

    @Autowired
    private FoodRepository repo;

    FoodController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // ✅ GET FOODS
    @GetMapping("/foods")
    public List<Food> getAllFoods() {

        if (repo.count() == 0) {
            List<Food> list = new ArrayList<>();

            list.add(new Food("Burger",120,"https://images.unsplash.com/photo-1568901346375-23c9450c58cd"));
            list.add(new Food("Pizza",250,"https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg"));
            list.add(new Food("Sandwich",150,"https://images.pexels.com/photos/1600711/pexels-photo-1600711.jpeg"));
            list.add(new Food("Pasta",200,"https://images.pexels.com/photos/1437267/pexels-photo-1437267.jpeg"));
            list.add(new Food("French Fries",100,"https://images.unsplash.com/photo-1573080496219-bb080dd4f877"));
            list.add(new Food("Noodles",180,"https://images.unsplash.com/photo-1585032226651-759b368d7246"));
            list.add(new Food("Momos",90,"https://images.pexels.com/photos/3926123/pexels-photo-3926123.jpeg"));
            list.add(new Food("Ice Cream",80,"https://images.unsplash.com/photo-1497034825429-c343d7c6a68f"));
            list.add(new Food("Milkshake",140,"https://images.unsplash.com/photo-1572490122747-3968b75cc699"));
            list.add(new Food("Samosa",40,"https://images.unsplash.com/photo-1601050690597-df0568f70950"));
            list.add(new Food("Mixed Vegetable Salad",110,"https://images.pexels.com/photos/1640777/pexels-photo-1640777.jpeg"));
            list.add(new Food("Cappuccino",120,"https://images.unsplash.com/photo-1509042239860-f550ce710b93"));

            repo.saveAll(list);
        }

        return repo.findAll();
    }

    // ✅ ADD FOOD
    @PostMapping("/foods")
    public Food addFood(@RequestBody Food food) {
        return repo.save(food);
    }

    // ✅ PLACE ORDER
    @PostMapping("/orders")
    public Order placeOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
     @GetMapping("/orders")
     public List<Order> getAllOrders() {
    	 return orderRepository.findAll();
     }

    
}