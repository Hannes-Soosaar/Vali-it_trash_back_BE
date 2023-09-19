package trash_back.domain.product.category;

import org.mapstruct.*;
import trash_back.business.product.dto.CategoryDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    @Mapping(source = "id", target = "categoryId")
    @Mapping(source = "name", target = "categoryName")
    CategoryDto toCategoryDto(Category category);

    List<CategoryDto> toCategoryDto(List<Category> allCategoryNames);
}
