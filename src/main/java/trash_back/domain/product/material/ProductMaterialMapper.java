package trash_back.domain.product.material;

import org.mapstruct.*;
import trash_back.business.product.dto.material.MaterialInfo;
import trash_back.business.product.dto.material.ProductMaterialDto;
import trash_back.business.search.dto.SearchResultUpcMaterial;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMaterialMapper {

    @Mapping(source = "material.name", target = "materialName")
    @Mapping(source = "material.bin.name", target = "materialBinName")
    @Mapping(source = "material.bin.color.name", target = "materialBinColorName")
    @Mapping(source = "material.category.name", target = "materialCategoryName")
    @Mapping(source = "material.bin.requirements", target = "materialBinRequirements")
    ProductMaterialDto toProductMaterialDto(ProductMaterial productMaterial);

    List<ProductMaterialDto> toProductMaterialDtos(List<ProductMaterial> toProductMaterial);

    @Mapping(source = "material.category.name", target = "materialCategoryName")
    @Mapping(source = "material.name", target = "materialName")
    @Mapping(source = "material.id", target = "materialId")
    MaterialInfo toMaterialInfo(ProductMaterial productMaterial);

    @Mapping(source = "material.name", target = "materialName")
    @Mapping(source = "material.bin.name", target = "materialBinName")
    @Mapping(source = "material.bin.color.name", target = "materialBinColorName")
    SearchResultUpcMaterial toSearchResultUpcMaterial(ProductMaterial productMaterial);


    List<SearchResultUpcMaterial> toSearchResultUpcMaterials(List<ProductMaterial> productMaterials);




    List<MaterialInfo> toMaterialInfos(List<ProductMaterial> productMaterials);


}