package com.todocodeAcademy.products_service.controller;

import com.todocodeAcademy.products_service.dto.ProductDTO;
import com.todocodeAcademy.products_service.model.Product;
import com.todocodeAcademy.products_service.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService prodServ;
    public ProductController(ProductService prodServ){
        this.prodServ = prodServ;
    }

    @PostMapping()
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product){
        Product saved = prodServ.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<?> getProduct(@PathVariable Long productCode){
        Product prod = prodServ.getProduct(productCode);
        return ResponseEntity.ok(prod);
    }

    @PutMapping("/{originalCode}")
    public ResponseEntity<?> updateProduct(@PathVariable Long originalCode, @Valid @RequestBody Product newProduct){
        Product updated = prodServ.updateProduct(originalCode, newProduct);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{productCode}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productCode){
        prodServ.deleteProduct(productCode);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<?> getAllProducts(){
        List<Product> list = prodServ.getAllProducts();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/search/by-name/{prodName}")
    public ResponseEntity<?> getProductByProductName(@PathVariable String prodName){
        Product product = prodServ.getProductByProdName(prodName);
        ProductDTO p = new ProductDTO(product.getProductCode(), product.getProductName(), product.getProductPrice());
        return ResponseEntity.ok(p);
    }
}
