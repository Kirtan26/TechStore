package net.TechStore.controller;




import net.TechStore.DTO.ProductDTO;
import net.TechStore.model.Category;
import net.TechStore.model.Product;
import net.TechStore.service.CategoryService;
import net.TechStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/admin")
    public String adminhome() {

        return "adminHome";
    }



    //  Categories Section

    @GetMapping("/admin/categories")
    public String goToCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String goToAddCategories(Model model) {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postAddCategories(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCategory(@PathVariable int id, Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()){
            model.addAttribute("category",category.get());
            return "categoriesAdd";
        } else {
            return "404";
        }

    }

  /*  //  Product Section

    @GetMapping("/admin/products")
    public String goToProducts(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String goToAddProducts(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categories",categoryService.getAllCategory());
        return "productsAdd";
    }


 */


/*    @PostMapping("/admin/products/add")
    public String postProductAdd(@ModelAttribute("productDTO") ProductDTO productDTO,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam("imgName")String imgName) throws IOException {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setYear(productDTO.getYear());
        product.setDescription(productDTO.getDescription());

        String imageUUID;

        if(!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
//            String uploadDirectory;
            if (uploadDirectory != null) {
                Path fileNameAndPath = Paths.get(uploadDirectory, imageUUID);
                Files.write(fileNameAndPath, file.getBytes());
            } else {
                throw new RuntimeException("uploadDirectory is null");
            }
        }
            else {
            imageUUID = imgName;
        }
        product.setImageName(imageUUID);
        productService.addProduct(product);

        return "redirect:/admin/products";

    }



    @PostMapping("/admin/products/add")
    public String addingProducts(@ModelAttribute("productDTO")ProductDTO productDTO,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam("imgName")String imgName ) throws IOException {

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setYear(productDTO.getYear());
        product.setDescription(productDTO.getDescription());

        String imageUUID;

        if(!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = imgName;
        }

        product.setImageName(imageUUID);
        productService.addProduct(product);

        return "redirect:/admin/products";

    }


 */

    @GetMapping("/admin/products")
    public String adminProduct(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }

    //admin->products->add
    @GetMapping("/admin/products/add")
    public String getAdminProductAdd(Model model) {
        model.addAttribute("productDTO",  new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "productsAdd";
    }

    //admin->products->add->products
    @PostMapping("/admin/products/add")
    public String postAdminProductAdd(@ModelAttribute("productDTO")ProductDTO productDTO,
                                      @RequestParam("productImage")MultipartFile file,
                                      @RequestParam("imgName")String imgName) throws IOException {
        String imageUUID;
        Product product = new Product();

        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setYear(productDTO.getYear());
        product.setDescription(productDTO.getDescription());

        if(!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        }
        else {
            imageUUID = imgName;
        }
        product.setImageName(imageUUID);
        productService.addProduct(product);
        return "redirect:/admin/products";
    }

    //admin->products->update
    @GetMapping("/admin/products/update/{id}")
    public String updateProduct(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id).get();
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setYear(product.getYear());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageName(product.getImageName());

        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("productDTO", productDTO);
        return "productsAdd";
    }

    //admin->products->delete->products
    @GetMapping("/admin/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.removeProduct(id);
        return "redirect:/admin/products";
    }


}
