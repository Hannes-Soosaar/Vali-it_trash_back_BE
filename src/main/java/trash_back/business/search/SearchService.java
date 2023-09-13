package trash_back.business.search;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.business.product.dto.material.ProductMaterialDto;
import trash_back.business.product.material.ProductMaterialsService;
import trash_back.domain.search.RecyclingProfileService;

import java.util.List;


@Service
public class SearchService {

    @Resource
    private RecyclingProfileService recyclingProfileService; // Domain Service Class
    @Resource
    private ProductMaterialsService productMaterialsService; // Materials Service declaration

    public List<ProductMaterialDto> getProductProfileBy(String upc) {
        Integer productId = recyclingProfileService.findProductIdBy(upc);
        return productMaterialsService.getProductMaterials(productId);
    }

}
