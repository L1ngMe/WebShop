package com.ling.aplication.services;

import com.ling.aplication.models.Product;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Getter
    private List<Product> products = new ArrayList<>();
    private Long id = 1L;

    {
        products.add(new Product(id++, "Car", "Heel duur auto", 1000, "Paris", "Ik"));
        products.add(new Product(id++, "Carersrsrsf", "Heel duur aufsdfto", 10002, "Parisd", "Iks"));
    }

    public void add(Product product) {
        product.setId(id++);
        products.add(product);
    }

    public void delete(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
