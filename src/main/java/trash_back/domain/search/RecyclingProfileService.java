package trash_back.domain.search;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.domain.product.Product;
import trash_back.domain.product.ProductRepository;

@Service
public class RecyclingProfileService {

    // possibly might want to move the method to ProductService?
    @Resource
    private ProductRepository productRepository;

//todo make sure to ignore case.

    public Integer findProductIdBy(String upc) {
        Product product = productRepository.findProductIdBy(upc); // will return only one single product
        return product.getId(); // Returns the Id form the product
    }

}
