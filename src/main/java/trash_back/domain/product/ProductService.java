package trash_back.domain.product;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.business.login.Status;
import trash_back.validation.ValidationService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;


    public List<Product> findActiveProductsBy(Integer companyId) {
        return productRepository.findProductsBy(companyId, Status.ACTIVE.getLetter());
    }

    // todo need to add Company to the Product.
    public void saveProduct(Product product) {
        productRepository.save(product);
    }


    public Product getProductBy(Integer productId) {
        return productRepository.getReferenceById(productId);
    }

    public Product getValidActiveProductBy(Integer productId) {
        return productRepository.findProductBy(productId);
    }

    public Product getValidActiveProductBy(String upc) {
        Optional<Product> optionalProduct = productRepository.findProductBy(upc, Status.ACTIVE.getLetter());
        return ValidationService.getValidProduct(optionalProduct);
    }
}
