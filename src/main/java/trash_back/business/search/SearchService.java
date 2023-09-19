package trash_back.business.search;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.business.product.material.ProductMaterialsService;
import trash_back.business.search.dto.SearchResultUpc;
import trash_back.business.search.dto.SearchResultUpcMaterial;
import trash_back.domain.product.Product;
import trash_back.domain.product.ProductMapper;
import trash_back.domain.product.ProductService;
import trash_back.domain.product.material.MaterialMapper;
import trash_back.domain.product.material.MaterialService;
import trash_back.domain.product.productmaterial.ProductMaterial;
import trash_back.domain.product.productmaterial.ProductMaterialMapper;
import trash_back.domain.product.productmaterial.ProductMaterialService;
import trash_back.business.search.dto.SearchResultMaterial;
import trash_back.domain.product.material.Material;
import trash_back.domain.search.RecyclingProfileService;

import java.util.List;


@Service
public class SearchService {

    @Resource
    private RecyclingProfileService recyclingProfileService; // Domain Service Class
    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductMaterialMapper productMaterialMapper;

    @Resource
    private ProductService productService;

    @Resource
    private ProductMaterialService productMaterialService;

    @Resource
    private MaterialService materialService;

    @Resource
    private MaterialMapper materialMapper;

    @Resource
    private ProductMaterialsService productMaterialsService; // Materials Service declaration

//    public List<ProductMaterialDto> getProductProfileBy(String upc) {
//        Integer productId = recyclingProfileService.findProductIdBy(upc);
//        return productMaterialsService.getProductMaterials(productId);
//    }
//    public ProductSearchResultByUpc getProductInfoBy(String upc) {
//        Product product = recyclingProfileService.getProductDetailsBy(upc);
//        return productMapper.toProductSearchResult(product);
//    }


    //    public ProductSearchResultByUpc getProductInfoBy(String upc) {
//        Product product = recyclingProfileService.getProductDetailsBy(upc);
//        return productMapper.toProductSearchResult(product);
//    }



    public SearchResultUpc searchProductAndRecyclingInfo(String upc) {
        Product product = productService.getValidActiveProductBy(upc);
        SearchResultUpc searchResultUpc = productMapper.toSearchResultUpc(product);

        Integer productId = product.getId();
        List<ProductMaterial> productMaterials = productMaterialService.findMaterialsBy(productId);
        List<SearchResultUpcMaterial> searchResultUpcMaterials = productMaterialMapper.toSearchResultUpcMaterials(productMaterials);
        searchResultUpc.setMaterials(searchResultUpcMaterials);
        return searchResultUpc;

    }

    public SearchResultMaterial searchMaterialInfo(String materialName) {
        Material material = materialService.getValidMaterialBy(materialName);
        return materialMapper.toSearchResultMaterial(material);
    }

}
