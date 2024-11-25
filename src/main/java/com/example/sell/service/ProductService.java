package com.example.sell.service;

import com.example.sell.model.Product;
import com.example.sell.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Lấy tất cả sản phẩm
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Thêm sản phẩm mới
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    // Tìm sản phẩm theo id
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    // Cập nhật sản phẩm
    public Product save(Product product) {
        return productRepository.save(product);
    }

    // Xóa sản phẩm theo id
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
