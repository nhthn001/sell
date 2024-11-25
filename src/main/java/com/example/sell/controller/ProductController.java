package com.example.sell.controller;

import com.example.sell.model.Product;
import com.example.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id, Product updatedProduct) {
        Product product = productService.findById(id)
                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại!"));
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setStock(updatedProduct.getStock());
        productService.save(product);
        return "redirect:/products";
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        System.out.println("Deleting product with id: " + id);
        productService.deleteById(id);
        return "redirect:/products";
    }

    @PostMapping("/products/{id}")
    public String handleMethodOverride(@PathVariable Long id, @RequestParam("_method") String method) {
        if ("DELETE".equals(method)) {
            return deleteProduct(id);
        }
        return "redirect:/products"; // fallback if the method is not DELETE
    }

}
