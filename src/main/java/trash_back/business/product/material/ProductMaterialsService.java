package trash_back.business.product.material;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.business.product.dto.material.ProductMaterialDto;
import trash_back.domain.product.category.Category;
import trash_back.business.product.dto.CategoryDto;
import trash_back.domain.product.category.CategoryMapper;
import trash_back.domain.product.material.Material;
import trash_back.domain.product.material.MaterialMapper;
import trash_back.business.product.dto.MaterialNameDto;
import trash_back.domain.product.productmaterial.ProductMaterial;
import trash_back.domain.product.productmaterial.ProductMaterialMapper;
import trash_back.domain.product.productmaterial.ProductMaterialService;

import java.util.List;

@Service
public class ProductMaterialsService {

    @Resource
    private ProductMaterialMapper productMaterialMapper;
    @Resource
    private ProductMaterialService productMaterialService;

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private MaterialMapper materialMapper;


    public List<ProductMaterialDto> getProductMaterials(Integer productId) {
        List<ProductMaterial> productMaterials = productMaterialService.findMaterialsBy(productId);
        return productMaterialMapper.toProductMaterialDtos(productMaterials);
    }

    public List <CategoryDto> getCategoryNames() {
        List<Category> allCategoryNames = productMaterialService.getAllCategoryNames();
        List <CategoryDto> categories = categoryMapper.toCategoryDto(allCategoryNames);
        return categories;
    }


    public List<MaterialNameDto> getMaterialNames(Integer categoryId) {
        List<Material> materialNames = productMaterialService.getMaterialNames(categoryId);
        List <MaterialNameDto> materials = materialMapper.toMaterialName(materialNames);
        return materials;

    }
}
