package trash_back.domain.product;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.validation.ValidationService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;


    public List<Product> findProductProfileBy(Integer companyId) {
        return productRepository.findProductsBy(companyId);
    }

    // todo need to add Company to the Product.
    public void saveProduct(Product product) {
        productRepository.save(product);
    }


    public Product getProductProfileBy(Integer productId) {
        return productRepository.getReferenceById(productId);
    }

    public Product getValidProductBy(Integer productId) {
        return productRepository.findProductBy(productId);
    }

    public Product getValidProductBy(String upc) {
        Optional<Product> optionalProduct = productRepository.findProductBy(upc);
        return ValidationService.getValidProduct(optionalProduct);
    }
}
