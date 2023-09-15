package trash_back.business.product;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import trash_back.business.product.dto.ImageRequest;
import trash_back.business.product.dto.ProductProfile;
import trash_back.business.product.dto.ProductRequest;
import trash_back.domain.company.CompanyService;
import trash_back.domain.product.image.Image;
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

    @Resource
    private CompanyService companyService;

    public List<ProductProfile> getProductProfiles(Integer companyId) {
        List<Product> products = productService.findProductProfileBy(companyId);
        return productMapper.toProductProfiles(products);
    }

    //Transactional - It ensures that the entire operation is atomic, and if any part of it fails,
    // the entire transaction is rolled back.
    @Transactional
    public void addProductProfile(ProductRequest productRequest) {

        // initialize local variables
        String imageData = productRequest.getImageData();
        Product product = productMapper.toProduct(productRequest);
        product.setCompany(companyService.getCompanyBy(productRequest.getUserId()));

       if(imageData != null && !imageData.isEmpty()){
           Image image = ImageConverter.imageDataToImage(imageData);
           imageService.saveImage(image);
           product.setImage(image);
        }
        productService.saveProduct(product);
    }

//todo Changed from Post to Put.
    public void modifyProductPicture(Integer productId, ImageRequest imageRequest) {
        String imageData = imageRequest.getImageData();

        if(!imageData.isEmpty()){
            Product product = productService.findProductBy(productId);

            Image image = ImageConverter.imageDataToImage(imageData);
            imageService.saveImage(image);
            product.setImage(image);
            productService.saveProduct(product);
        } else{
            return;
        }
    }
}
