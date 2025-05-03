package com.roberto.curso.springboot.app.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roberto.curso.springboot.app.springboot_crud.entities.Product;
import com.roberto.curso.springboot.app.springboot_crud.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> deleteById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        productOptional.ifPresent(productDb -> {
            productRepository.deleteById(id);
        });

        return productOptional;
    }

    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {

        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Product productDb = productOptional.get();
            productDb.setName(product.getName());
            productDb.setPrice(product.getPrice());
            productDb.setDescription(product.getDescription());
            productDb.setSku(product.getSku());

            return Optional.of(productRepository.save(productDb));
        }
        return productOptional;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsBySku(String sku) {
        return productRepository.existsBySku(sku);
    }
}
