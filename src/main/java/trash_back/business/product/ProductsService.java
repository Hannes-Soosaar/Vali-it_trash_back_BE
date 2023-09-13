package trash_back.business.product;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import trash_back.business.product.dto.ProductProfile;
import trash_back.business.product.dto.ProductRequest;
import trash_back.domain.product.image.Image;
import trash_back.domain.company.Company;
import trash_back.domain.product.Product;
import trash_back.domain.product.ProductMapper;
import trash_back.domain.product.ProductService;
import trash_back.domain.product.image.ImageService;
import trash_back.util.ImageConverter;

import java.util.List;

@Service
public class ProductsService {

    @Resource
    private ProductService productService;


    @Resource
    private ProductMapper productMapper;

    @Resource
    private ImageService imageService;



    public List<ProductProfile> getProductProfile(Integer companyId) {
        List<Product> products = productService.findProductProfileBy(companyId);
        List<ProductProfile> productProfiles = productMapper.toProductProfiles(products);
        return productProfiles;


    }



    //Transactional - It ensures that the entire operation is atomic, and if any part of it fails,
    // the entire transaction is rolled back.
    @Transactional
    public void addProductProfile(ProductRequest productRequest) {

        //klassi nime järgi toProduct
        Product product = productMapper.toProduct(productRequest);
        String imageData = productRequest.getImageData();


        if(productRequest.getImageData() != null && !productRequest.getImageData().isEmpty()){
            Image image = ImageConverter.imageDataToImage(imageData);
            imageService.saveImage(image);
            product.setImage(image);

        }

        productService.saveProduct(product);
    }


}
