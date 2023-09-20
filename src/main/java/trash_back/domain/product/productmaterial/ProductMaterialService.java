package trash_back.domain.product.productmaterial;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.domain.product.category.Category;
import trash_back.domain.product.category.CategoryRepository;
import trash_back.domain.product.material.Material;
import trash_back.domain.product.material.MaterialRepository;

import java.util.List;

@Service
public class ProductMaterialService {

    @Resource
    private ProductMaterialRepository productMaterialRepository;
    @Resource
    private CategoryRepository categoryRepository;

    @Resource
    MaterialRepository materialRepository;



    public List<ProductMaterial> findMaterialsBy(Integer productId) {
        return productMaterialRepository.findProductMaterialBy(productId);
    }


    public List<Category> getAllCategoryNames() {
        return categoryRepository.findAll();
    }

    public List<Material> getMaterialNames(Integer categoryId) {
        return materialRepository.getMaterialsBy(categoryId);

    }


    public void saveProductMaterial(ProductMaterial productMaterial) {
        productMaterialRepository.save(productMaterial);
    }
}
