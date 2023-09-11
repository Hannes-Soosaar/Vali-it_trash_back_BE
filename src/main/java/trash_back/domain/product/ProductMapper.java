package trash_back.domain.product;

import org.mapstruct.*;
import trash_back.business.product.ProductProfile;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {


    @Mapping(source = "id", target = "productId")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "upc", target = "productUpc")
    @Mapping(source = "info", target = "productInfo")
    @Mapping(source = "status", target = "productStatus")

    ProductProfile toProductProfile(Product product);
   List<ProductProfile> toProductProfiles (List<Product> products);


}