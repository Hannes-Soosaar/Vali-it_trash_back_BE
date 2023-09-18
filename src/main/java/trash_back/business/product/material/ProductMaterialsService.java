package trash_back.business.product.material;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.business.product.dto.material.ProductMaterialDto;
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
    public List<ProductMaterialDto> getProductMaterials(Integer productId) {
        List<ProductMaterial> productMaterials = productMaterialService.findMaterialsBy(productId);
        return productMaterialMapper.toProductMaterialDtos(productMaterials);
    }

}
