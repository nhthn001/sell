package com.example.sell.controller;

import com.example.sell.model.Product;
import com.example.sell.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        // Lấy tất cả sản phẩm từ database
        List<Product> products = productRepository.findAll();
        // Đưa danh sách sản phẩm vào model để truyền sang view
        model.addAttribute("products", products);
        return "home"; // Tên file HTML trong thư mục templates
    }
}
