package com.ling.aplication.controllers;

import com.ling.aplication.models.Product;
import com.ling.aplication.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/")
    public String getProducts(Model model) {
        model.addAttribute("products", service.getProducts());
        return "products";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) {
        service.add(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/product/{id}")
    public String getInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", service.getProductById(id));
        return "product-info";
    }

}
