package trash_back.business.product;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import trash_back.business.product.dto.ImageRequest;
import trash_back.business.login.Status;
import trash_back.business.product.dto.ProductProfile;
import trash_back.business.product.dto.ProductRequest;
import trash_back.business.product.dto.ProductBasicProfile;
import trash_back.business.product.image.ImageResponse;
import trash_back.domain.company.CompanyService;
import trash_back.business.product.dto.material.MaterialInfo;
import trash_back.domain.product.ProductResponse;
import trash_back.domain.product.image.Image;
import trash_back.domain.product.Product;
import trash_back.domain.product.ProductMapper;
import trash_back.domain.product.ProductService;
import trash_back.domain.product.image.ImageService;
import trash_back.domain.product.productmaterial.ProductMaterial;
import trash_back.domain.product.productmaterial.ProductMaterialMapper;
import trash_back.domain.product.productmaterial.ProductMaterialService;
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
        return productProfiles;
    }

    @Transactional
    public ProductResponse addProductProfile(ProductRequest productRequest) {
        String imageData = productRequest.getImageData();
        Product product = productMapper.toProduct(productRequest);
        product.setCompany(companyService.getCompanyBy(productRequest.getUserId()));

        if (imageData != null && !imageData.isEmpty()) {
            Image image = ImageConverter.imageDataToImage(imageData);
            imageService.saveImage(image);
            product.setImage(image);
        }
        productService.saveProduct(product);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(product.getId());
        return productResponse;
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

    public void modifyProductPicture(Integer productId, ImageRequest imageRequest) {
        String imageData = imageRequest.getImageData();
        Product product = productService.getValidProductBy(productId);

        if (!imageData.isEmpty() && product.getId() != null) {
            // find ImageId to overwrite.
            Image existingImage = product.getImage();
            Integer existingImageId = existingImage.getId();
            // convert Image request to to an Image object with ImageData as a Byte array
            Image image = ImageConverter.imageDataToImage(imageData);
            image.setId(existingImageId); // add the existing image id to new image to be save
            imageService.saveImage(image); // save the image object
            product.setImage(image);    // add the image object to the found product.
            productService.saveProduct(product); // save the product.
        } else {

            // run no image to add or file empty.
        }
    }

    public ImageResponse getProductImage(Integer productId) {
        Product product = productService.getValidProductBy(productId);
        return productMapper.toImageResponse(product);
    }

}

