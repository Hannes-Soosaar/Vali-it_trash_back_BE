package trash_back.domain.product.material;

import org.mapstruct.*;
import trash_back.business.search.dto.SearchResultMaterial;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MaterialMapper {

    @Mapping(source = "bin.name", target = "binName")
    @Mapping(source = "bin.color.name", target = "binColor")
    @Mapping(source = "bin.requirements", target = "binRequirements")
    SearchResultMaterial toSearchResultMaterial(Material material);


}