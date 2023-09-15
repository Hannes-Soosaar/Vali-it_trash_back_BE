package trash_back.business.product;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;
import trash_back.business.product.dto.ImageRequest;
import trash_back.business.login.Status;
import trash_back.business.product.dto.ProductProfile;
import trash_back.business.product.dto.ProductRequest;
import trash_back.domain.company.CompanyService;
import trash_back.business.product.dto.material.MaterialInfo;
import trash_back.domain.product.ProductBasicProfile;
import trash_back.domain.product.image.Image;
import trash_back.domain.company.Company;
import trash_back.domain.product.Product;
import trash_back.domain.product.ProductMapper;
import trash_back.domain.product.ProductService;
import trash_back.domain.product.image.ImageService;
import trash_back.domain.product.material.ProductMaterial;
import trash_back.domain.product.material.ProductMaterialMapper;
import trash_back.domain.product.material.ProductMaterialService;
import trash_back.util.ImageConverter;

import java.util.List;

@Service
public class ProductsService {

    @Resource
    private ProductService productService;

    @Resource
    private ProductMapper productMapper;


    @Resource
    private ProductMaterialService productMaterialService;

    @Resource
    private ProductMaterialMapper productMaterialMapper;

    @Resource
    private ImageService imageService;


    @Resource
    private CompanyService companyService;

    public List<ProductProfile> getProductProfiles(Integer companyId) {
        List<Product> products = productService.findProductProfileBy(companyId);
        List<ProductProfile> productProfiles = productMapper.toProductProfiles(products);

        for (ProductProfile productProfile : productProfiles) {
            List<ProductMaterial> materials = productMaterialService.findMaterialsBy(productProfile.getProductId());
            List<MaterialInfo> materialInfos = productMaterialMapper.toMaterialInfos(materials);
            productProfile.setMaterials(materialInfos);
        }


        //productMaterialsService.getProductMaterials()
        return productProfiles;

    }



    //Transactional - It ensures that the entire operation is atomic, and if any part of it fails,
    // the entire transaction is rolled back.
    @Transactional
    public void addProductProfile(ProductRequest productRequest) {

        // TODO: 13/09/2023 leidke companyId abil ylesse company objekt (via companyService -> companyRepository)

        // initialize local variables
        String imageData = productRequest.getImageData();
        //klassi nime järgi toProduct
        Product product = productMapper.toProduct(productRequest);
        product.setCompany(companyService.getCompanyBy(productRequest.getUserId()));

        if (imageData != null && !imageData.isEmpty()) {
            Image image = ImageConverter.imageDataToImage(imageData);
            imageService.saveImage(image);
            product.setImage(image);
        }

        productService.saveProduct(product);
    }


    public void deleteProductProfile(Integer productId) {
        Product product = productService.getProductProfileBy(productId);
        product.setStatus(Status.DELETED.getLetter());
        productService.saveProduct(product);

    }

    public void updateProductProfile(Integer productId, ProductBasicProfile productRequest) {
        Product product = productService.getProductProfileBy(productId);
        productMapper.partialUpdate(productRequest, product);
        productService.saveProduct(product);
    }

    //todo Changed from Post to Put.
    public void modifyProductPicture(Integer productId, ImageRequest imageRequest) {
        String imageData = imageRequest.getImageData();

        if (!imageData.isEmpty()) {
            Product product = productService.findProductBy(productId);

            Image image = ImageConverter.imageDataToImage(imageData);
            imageService.saveImage(image);
            product.setImage(image);
            productService.saveProduct(product);
        } else {
            return;
        }
    }


}
