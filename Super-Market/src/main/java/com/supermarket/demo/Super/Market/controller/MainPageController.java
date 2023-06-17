package com.supermarket.demo.Super.Market.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.supermarket.demo.Super.Market.Model.Item;

import com.supermarket.demo.Super.Market.Repo.ItemRepo;


@Controller
public class MainPageController {

	@Autowired
	ItemRepo repoi;
	
	
	
//	@Autowired
//	TotalRepo repot;
	
	private Item item;
	
	List<Item> wishlist = new ArrayList<Item>();
	
//	@RequestMapping("/cart")
//	public String cart() {
//
//	    return "Cart.jsp";
//	}

	
	
	
	@RequestMapping("/wishlist")
	public String wishlist(Model model) {
		
		model.addAttribute("wishlists", wishlist);

	    return "Wishlist.jsp";
	}
	
	@RequestMapping("/wishlist/{name}")
	public String addToCart(@PathVariable String name) {
		item = repoi.findByItemName(name);
		wishlist.add(item);
		
		//System.out.println(cart.size());
	//System.out.println(wishlist);
	
	    return "redirect:/home";
	}
	
	@RequestMapping("/deletewishlist/{name}")
	public String deleteCartItem(@PathVariable String name) {
		
		for (Iterator<Item> iterator = wishlist.iterator(); iterator.hasNext(); ) {
		    Item value = iterator.next();
		    if (value.getItemName().equals(name)) {
		    
		        iterator.remove();
		    }
		}

	    return "redirect:/wishlist";
	}
	
	@RequestMapping("/contact")
	public String contact() {

	    return "Contact.jsp";
	}
	
	
	
	
	
	
}
