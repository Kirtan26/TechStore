package net.TechStore.controller;

import net.TechStore.global.GlobalData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {

		return "login";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("cartCount", GlobalData.cart.size());

		return "index";
	}
}
