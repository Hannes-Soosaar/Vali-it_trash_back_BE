package trash_back.domain.product;

import org.mapstruct.*;
import trash_back.business.product.dto.ProductProfile;
import trash_back.business.product.dto.ProductRequest;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {


    @Mapping(source = "id", target = "id")
    @Mapping(source = "company.name", target = "companyName")
    @Mapping(source = "upc", target = "upc")
    @Mapping(source = "info", target = "productInfo")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "image.id", target = "imageId")
//    @Mapping(source = "image.data", target = "imageData")
    ProductProfile toProductProfile(Product product);

    List<ProductProfile> toProductProfiles(List<Product> products);


    @Mapping(source = "productInfo", target = "info")
    @Mapping(source = "productName", target = "name")
    Product toProduct(ProductRequest productRequest);


}