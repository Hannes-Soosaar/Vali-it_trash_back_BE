package trash_back.domain.product;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.business.product.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;

    public List<Product> findProductProfileBy(Integer companyId) {
        return productRepository.findProductsBy(companyId);

    }

}
