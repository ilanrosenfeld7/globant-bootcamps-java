package com.shoppingcart.shoppingcart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;  

@Controller
public class ShoppingCartController {

    @GetMapping("/index")
    public String index(@RequestParam(value="product", defaultValue="") String prod, Model model) {
    	model.addAttribute("product", prod); 
        return "index";
    }
    
    @GetMapping("/index/{product}")
    public String indexP(@RequestParam(value="product", defaultValue="") String prod, Model model) {
    	model.addAttribute("product", prod); 
        return "index";
    }
    

    }
