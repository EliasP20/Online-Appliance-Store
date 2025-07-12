package com.todocodeAcademy.products_service.service;

import com.todocodeAcademy.products_service.model.Product;
import com.todocodeAcademy.products_service.repository.IProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository prodRepo;

    @Override
    public Product createProduct(Product p) {
        if(prodRepo.findByProductNameIgnoreCase(p.getProductName()).isPresent()){
            throw new IllegalArgumentException("Product with name '" + p.getProductName() + "' already exists");
        }
        return prodRepo.save(p);
    }

    @Override
    public Product getProduct(Long prodId) {
        return prodRepo.findById(prodId).orElseThrow(() -> new EntityNotFoundException("Product with code " + prodId + " not found"));
    }

    @Override
    public Product updateProduct(Long productCode, Product newProduct) {
        Product original = getProduct(productCode);

        original.setProductName(newProduct.getProductName());
        original.setProductBrand(newProduct.getProductBrand());
        original.setProductPrice(newProduct.getProductPrice());
        return prodRepo.save(original);
    }

    @Override
    public void deleteProduct(Long prodCode) {
        getProduct(prodCode);
        prodRepo.deleteById(prodCode);
    }

    @Override
    public List<Product> getAllProducts() {
        return prodRepo.findAll();
    }

    @Override
    public Product getProductByProdName(String prodName) {
        return prodRepo.findByProductNameIgnoreCase(prodName)
                .orElseThrow(() -> new EntityNotFoundException("Product with name " + prodName + " not found"));
    }
}
