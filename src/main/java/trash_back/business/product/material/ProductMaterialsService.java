package trash_back.business.product.material;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.business.product.dto.material.ProductMaterialDto;
import trash_back.domain.product.material.ProductMaterial;
import trash_back.domain.product.material.ProductMaterialMapper;
import trash_back.domain.product.material.ProductMaterialService;

import java.util.List;

@Service
public class ProductMaterialsService {


    // gives access to the desired mapper
    @Resource
    private ProductMaterialMapper productMaterialMapper;

    // gives access to the domain side Service.
    @Resource
    private ProductMaterialService productMaterialService;

    public List<ProductMaterialDto> getProductMaterials(Integer productId) {
        List<ProductMaterial> productMaterials = productMaterialService.findMaterialsBy(productId);
        return productMaterialMapper.toProductMaterialDtos(productMaterials);
    }


}
