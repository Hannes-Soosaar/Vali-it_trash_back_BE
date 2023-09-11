package trash_back.business.product;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.domain.product.Product;
import trash_back.domain.product.ProductMapper;
import trash_back.domain.product.ProductService;

import java.util.List;

@Service
public class ProductsService {

    @Resource
    private ProductService productService;

    @Resource
    private ProductMapper productMapper;


    public List<ProductProfile> getProductProfile(Integer companyId) {
        List<Product> products = productService.findProductProfileBy(companyId);
        List<ProductProfile> productProfiles = productMapper.toProductProfiles(products);
        return productProfiles;


    }
}
