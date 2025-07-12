package com.todocodeAcademy.products_service.service;

import com.todocodeAcademy.products_service.model.Product;

import java.util.List;

public interface IProductService {
    // Create a product
    Product createProduct(Product p);

    //Read a product
    Product getProduct(Long prodId);

    //Update a product
    Product updateProduct(Long productCode, Product newProduct);

    //Delete a product
    void deleteProduct(Long prodCode);

    //Get all products
    List<Product> getAllProducts();

    //Get product by product name
    Product getProductByProdName(String prodName);
}
