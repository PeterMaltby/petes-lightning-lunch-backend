package com.sainsburys.lightninglunchbackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sainsburys.lightninglunchbackend.models.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductService {

    private static final Logger logger = Logger.getLogger(ProductService.class.getName());

    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            products = mapper.readValue(getClass().getResourceAsStream("/products.json"), new TypeReference<>() {
            });
        } catch (IOException e) {
            logger.warning("Products not loaded!" + e);
        }
        System.out.println(getProduct("7798851").getAttributes().getName());
    }

    public Product getProduct(String productId) {
        for (Product product : products) {
            if (productId.equals(product.getId())) return product;
        }
        System.out.println("PRODUCT NOT FOUND");
        return null;
    }
}
