package trash_back.business.product.material;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trash_back.business.product.dto.material.ProductMaterialDto;

import java.util.List;

@RestController
public class MaterialsController {


    // All request from materials and down.
@Resource
    private ProductMaterialsService productMaterialsService;

@GetMapping("/productmaterials")

// get is used as there can not be a product without a material
    public List<ProductMaterialDto> getProductMaterialsList(@RequestParam Integer productId){
    return productMaterialsService.getProductMaterials(productId);

}


}
