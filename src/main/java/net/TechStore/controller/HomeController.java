package net.TechStore.controller;


import net.TechStore.global.GlobalData;
import net.TechStore.service.CategoryService;
import net.TechStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

//    @GetMapping("/")
//    public String home(Model model) {
//        model.addAttribute("cartCount", GlobalData.cart.size());
//
//        return "index";
//    }

    @GetMapping("/shop")
    public String goToShop(Model model) {
        model.addAttribute("cartCount",GlobalData.cart.size());

        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProduct());
        return "shop";
    }

   @GetMapping("/shop/category/{id}")
   public String goToShopCategories(Model model, @PathVariable int id) {
       model.addAttribute("cartCount",GlobalData.cart.size());

       model.addAttribute("categories", categoryService.getAllCategory());
       model.addAttribute("products", productService.getAllProductsByCategoryId(id));
       return "shop";
   }

   @GetMapping("/shop/viewproduct/{id}")
   public String shopViewProduct(Model model, @PathVariable Long id) {
       model.addAttribute("product", productService.getProductById(id).get());
       model.addAttribute("cartCount",GlobalData.cart.size());

       return "viewProduct";
   }


}
