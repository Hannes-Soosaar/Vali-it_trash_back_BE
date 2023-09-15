package trash_back.domain.product;

import org.mapstruct.*;
import trash_back.business.product.dto.ProductProfile;
import trash_back.business.product.dto.ProductRequest;
import trash_back.business.product.dto.material.MaterialInfo;
import trash_back.domain.product.material.ProductMaterial;

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
// all but the image data is mapped to a Product object
    Product toProduct(ProductRequest productRequest);


    @Mapping(source = "materialName", target = "material.name")
    @Mapping(source = "materialCategoryName", target = "material.category.name")
    @Mapping(source = "materialId", target = "material.id")
    ProductMaterial toEntity(MaterialInfo categoryNameDto);



    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "productName", target = "name")
    @Mapping(source = "productInfo", target = "info")
    Product partialUpdate(ProductBasicProfile productBasicProfile, @MappingTarget Product product);
}