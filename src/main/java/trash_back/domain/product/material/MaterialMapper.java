package trash_back.domain.product.material;

import org.mapstruct.*;
import trash_back.business.product.dto.MaterialNameDto;
import trash_back.business.search.dto.SearchResultMaterial;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MaterialMapper {

    @Mapping(source = "bin.name", target = "binName")
    @Mapping(source = "bin.color.name", target = "binColor")
    @Mapping(source = "bin.requirements", target = "binRequirements")
    SearchResultMaterial toSearchResultMaterial(Material material);


    @Mapping(source = "id", target = "materialId")
    @Mapping(source = "name", target = "materialName")
    MaterialNameDto toMaterialName(Material material);
    List<MaterialNameDto> toMaterialName(List<Material> materialNames);


}