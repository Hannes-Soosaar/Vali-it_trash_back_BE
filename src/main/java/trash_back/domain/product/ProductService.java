package trash_back.domain.product;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.domain.company.Company;
import trash_back.domain.company.CompanyRepository;
import trash_back.domain.product.image.ImageRepository;

import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;

    @Resource
    private CompanyRepository companyRepository;
    private final ImageRepository imageRepository;

    public ProductService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Product> findProductProfileBy(Integer companyId) {
        return productRepository.findProductsBy(companyId);

    }
    // todo need to add Company to the Product.
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Company getCompanyBy(Integer companyId) {
        return companyRepository.getReferenceById(companyId);
    }

    public Product getProductProfileBy(Integer productId) {
        return productRepository.getReferenceById(productId);
    }

    public Product findProductBy(Integer productId) {
        return productRepository.findProductBy(productId);
    }

}
