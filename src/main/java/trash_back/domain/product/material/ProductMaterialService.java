package trash_back.domain.product.material;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMaterialService {

    @Resource
    private ProductMaterialRepository productMaterialRepository;

    public List<ProductMaterial> findMaterialsBy(Integer productId) {
        return productMaterialRepository.findProductMaterialBy(productId);
    }

}
