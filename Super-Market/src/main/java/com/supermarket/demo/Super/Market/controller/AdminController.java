package com.supermarket.demo.Super.Market.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.supermarket.demo.Super.Market.Model.Card;
import com.supermarket.demo.Super.Market.Model.Item;
import com.supermarket.demo.Super.Market.Model.LoginUser;
import com.supermarket.demo.Super.Market.Model.Supplier;
import com.supermarket.demo.Super.Market.Model.User;
import com.supermarket.demo.Super.Market.Repo.CardRepo;
import com.supermarket.demo.Super.Market.Repo.ItemRepo;
import com.supermarket.demo.Super.Market.Repo.LoginRepo;
import com.supermarket.demo.Super.Market.Repo.SupplierRepo;
import com.supermarket.demo.Super.Market.Repo.UserRepo;

@Controller
public class AdminController {
	
	@Autowired
	ItemRepo repoi;
	
	@Autowired
	LoginRepo repol;
	
	@Autowired
	SupplierRepo repos;
	
	@RequestMapping("/login")
	public String login() {
		
	    return "Loginpage.jsp";
	}
	
	
	@RequestMapping("/homeadmin")
	public String homePage(Model model) {
		List<Item> item = repoi.findAll();
		// System.out.println(item);
		
		model.addAttribute("items", item);
		return "HomeAdmin.jsp";
	}
	
	
	
	
	
	
	@RequestMapping("/loginvalidation")
	public String login(@RequestParam(name="email") String email, Model model) {
		System.out.println(email);
		
		List<LoginUser> loginDetails = repol.findAll();
		for (Iterator<LoginUser> iterator = loginDetails.iterator(); iterator.hasNext();) {
			LoginUser value = iterator.next();
			
			if(value.getAdminRole().equalsIgnoreCase("admin") && value.getEmail().equals(email) ) {
				return "redirect:/homeadmin";
			}
			
			if(value.getEmail().equals(email) && value.getAdminRole().equalsIgnoreCase("user")) {
				return "redirect:/home";
			}
			
		}
		
	
		model.addAttribute("error", "Invalid Email - Please Register");
		

	    return "Loginpage.jsp";
	}
	
	@RequestMapping("/registration")
	public String registration(LoginUser login) {
		
		login.setAdminRole("user");
		
		repol.save(login);
		

	    return "Loginpage.jsp";
	}

	@RequestMapping("/adminadd")
	public String adminAdd() {

	    return "AdminAdd.jsp";
	}
	
	@RequestMapping("/supplier")
	public String supplier(Model model) {
		
		
		List<Supplier> suppliers = repos.findAll();
		
		model.addAttribute("suppliers", suppliers);


	    return "SupplierDetails.jsp";
	}
	
	@RequestMapping("/add")
	public  String addData(Item item) {
		repoi.save(item);
		
		//System.out.println(item);
		
		return "redirect:/homeadmin";
}
	
	
	
	@RequestMapping("/supplieradd")
	public  String addSupplier(Supplier supplier) {
		
		
		repos.save(supplier);

		
		return "redirect:/adminadd";
		
	}
	
	@RequestMapping("/deleteitem/{itemName}")
	public  String deleteItem(@PathVariable String itemName) {
		
		 Item item=repoi.findByItemName(itemName);
		 
		 Long itemId = item.getItemId();
		 
		 repoi.deleteById(itemId);

		
		return "redirect:/homeadmin";
		
	}
	
	
	

}
