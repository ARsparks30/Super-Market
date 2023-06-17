package com.supermarket.demo.Super.Market.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supermarket.demo.Super.Market.Model.Card;
import com.supermarket.demo.Super.Market.Model.Item;
import com.supermarket.demo.Super.Market.Model.User;

import com.supermarket.demo.Super.Market.Repo.CardRepo;
import com.supermarket.demo.Super.Market.Repo.ItemRepo;


import com.supermarket.demo.Super.Market.Repo.UserRepo;

@Controller
public class HomeController {

	

	@Autowired
	ItemRepo repoi;
	
	@Autowired
	UserRepo repou;
	
	@Autowired
	CardRepo repoc;
	
	

	private Item item;

	List<Item> cart = new ArrayList<Item>();

	Map<String, Integer> quantity = new HashMap<>();

	private int quant = 1;
	
	private Double total = 0.0;
	



	@RequestMapping("/home")
	public String homePage(Model model) {
		List<Item> item = repoi.findAll();
		// System.out.println(item);

		model.addAttribute("count", cart.size());
		model.addAttribute("items", item);
		return "Home.jsp";
	}

	@RequestMapping("/cart")
	public String cart(Model model) {
		//Double total = 0.0;
		Double priceWQuantity = 0.0;
		Double priceWOQuantity = 0.0;
		Double priceWQuantityG = 0.0;
		
	

		model.addAttribute("cartItems", cart);
		model.addAttribute("count", cart.size());
		model.addAttribute("quant", quantity);
	
		
		
		for (Iterator<Item> iterator = cart.iterator(); iterator.hasNext();) {
			Item value = iterator.next();
			
			if(quantity.isEmpty()) {
			total = total + value.getItemPrice() ;
			//System.out.println(total);
			}
		
			else {
		
			
		
			for (Map.Entry<String, Integer> quants : quantity.entrySet()) {
				
			
				 if (value.getItemName().equals(quants.getKey()) && value.getItemQuantity() >= quants.getValue()) {
					 
					 
					 priceWQuantity = priceWQuantity + value.getItemPrice()*quants.getValue();
					
				}else if(value.getItemName().equals(quants.getKey()) && value.getItemQuantity() < quants.getValue()) {
					priceWQuantityG =   priceWQuantityG +value.getItemPrice()*value.getItemQuantity(); 
					model.addAttribute("noItem", "Item Out Of Stock");
					//System.out.println("iii"+" "+ priceWQuantityG + " "+value.getItemName());
				}
				 
			
			}
			
			}
			if(!quantity.containsKey(value.getItemName())) {
				priceWOQuantity = priceWOQuantity +  value.getItemPrice();
				//System.out.println("ggg"+" "+priceWOQuantity + " "+value.getItemName());
			}
			
		}
		
		total = priceWQuantity + priceWOQuantity + priceWQuantityG;
		
		model.addAttribute("total", total);
			

		return "Cart.jsp";
	}

	@RequestMapping("/delete/{cartName}")
	public String deleteCartItem(@PathVariable String cartName) {

		for (Iterator<Item> iterator = cart.iterator(); iterator.hasNext();) {
			Item value = iterator.next();
			if (value.getItemName().equals(cartName)) {
				System.out.println(value);
				iterator.remove();
			}
		}

		return "redirect:/cart";
	}

	@RequestMapping("/cartitems/{name}")
	public String addToCart(@PathVariable String name) {
		item = repoi.findByItemName(name);
		cart.add(item);

		// System.out.println(cart.size());
		// System.out.println(cart);

		return "redirect:/home";
	}

	@RequestMapping("/cartupdate/{cartName}")
	public String cart(@PathVariable String cartName) {

		if (!quantity.containsKey(cartName)) {
	
			quantity.put(cartName, quant);
		
			
		}
		

		Iterator<Map.Entry<String, Integer>> iterator = quantity.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, Integer> quants = iterator.next();

				if (quants.getKey().equals(cartName) ) {

					//System.out.println(quants.getKey() + "  before  " + quants.getValue());
					Integer q = quants.getValue() + 1;
					quants.setValue(q);
					//System.out.println(q);

					//System.out.println(quants.getKey() + " " + quants.getValue());
					
					
				}
				
				
			

			//System.out.println(quants);
		}
		
		
		

		return "redirect:/cart";
		


		
	}
	
	
	@RequestMapping("/checkout")
	public String checkout(Model model) {
		
		
		model.addAttribute("total", total);
		
		if(total == 0.0) {
			model.addAttribute("totalError", "Cart is Empty!");
		}
		
		
		


	    return "Checkout.jsp";
	}
	
	
	@RequestMapping("/buynow/{name}")

	public String display(@PathVariable String name) {
		
		item = repoi.findByItemName(name);
		
		total = item.getItemPrice();
		
		return "redirect:/checkout";
	}
	
	@RequestMapping("/orderplaced")
	public String orderPlaced(Model model) {
		
        model.addAttribute("total", total);
		
		if(total == 0.0) {
			model.addAttribute("totalError", "Cart is Empty!");
		}
		

			model.addAttribute("success", "Successfully Ordered the Product");
		Double cash = 0.0;
		 List<User> users = repou.findAll();
		 Card card1 = repoc.getById(1L);
		 Card card2 = repoc.getById(2L);
		 
		for(User user : users) {
			if((user.getCardNumber().equals(card1.getCardNumber()))) {
				cash = card1.getCash() - total;
				card1.setCash(cash);
				repoc.save(card1);
				
				total = 0.0;
				model.addAttribute("success", "Successfully Ordered the Product");
			}
			if((user.getCardNumber().equals(card2.getCardNumber()))) {
				cash = card2.getCash() - total;
				card2.setCash(cash);
				repoc.save(card2);
				
				total = 0.0;
				model.addAttribute("success", "Successfully Ordered the Product");
			}
			
		}
		
		


	    return "Checkout.jsp";
	}
	
	@RequestMapping("/userdetails")
	public  String addUserDetails(User user, Model model) {
		
		Card card1 = repoc.getById(1L);
		Card card2 = repoc.getById(2L);
		
		
		
		if((user.getCardNumber().equals(card1.getCardNumber())) ||  user.getCardNumber().equals(card2.getCardNumber()) ) {
			repou.save(user);
			
			
			model.addAttribute("total", total);
			
			model.addAttribute("success", "Details Successfully added");
			return "Checkout.jsp";
			
			
		}
		else {
			
			model.addAttribute("total", total);
			model.addAttribute("success", "Please Enter correct details");
			return "Checkout.jsp";
		}
		
		
}
	

	
	

}