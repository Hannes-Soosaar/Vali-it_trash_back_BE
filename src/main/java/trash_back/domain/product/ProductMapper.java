package trash_back.domain.product;

import org.mapstruct.*;
import trash_back.business.product.dto.ProductProfile;
import trash_back.business.product.dto.ProductRequest;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    @Mapping(source = "id", target = "productId")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "upc", target = "upc")
    @Mapping(source = "info", target = "productInfo")
    @Mapping(source = "status", target = "status")
    ProductProfile toProductProfile(Product product);
    List<ProductProfile> toProductProfiles(List<Product> products);

    @Mapping(source = "productInfo", target = "info")
    @Mapping(source = "productName", target = "name")
    Product toProduct(ProductRequest productRequest);


}