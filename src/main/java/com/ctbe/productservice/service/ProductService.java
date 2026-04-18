package com.ctbe.productservice.service;

import com.ctbe.productservice.dto.ProductRequest;
import com.ctbe.productservice.dto.ProductResponse;
import com.ctbe.productservice.exception.ResourceNotFoundException;
import com.ctbe.productservice.model.Product;
import com.ctbe.productservice.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return toResponse(product);
    }

    public ProductResponse create(ProductRequest req) {
        Product product = toEntity(req);
        Product savedProduct = productRepository.save(product);
        return toResponse(savedProduct);
    }

    public ProductResponse update(Long id, ProductRequest req) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        product.setName(req.getName());
        product.setPrice(req.getPrice());
        product.setStockQty(req.getStockQty());
        product.setCategory(req.getCategory());

        Product updatedProduct = productRepository.save(product);
        return toResponse(updatedProduct);
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        productRepository.delete(product);
    }

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStockQty(),
                product.getCategory()
        );
    }

    private Product toEntity(ProductRequest req) {
        return new Product(
                req.getName(),
                req.getPrice(),
                req.getStockQty(),
                req.getCategory()
        );
    }
}
