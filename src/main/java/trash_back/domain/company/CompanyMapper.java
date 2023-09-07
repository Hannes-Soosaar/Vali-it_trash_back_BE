package trash_back.domain.company;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {

    @Mapping(source = "id", target = "companyId")
    @Mapping(source = "name", target = "companyName")
    @Mapping(source = "registrationcode", target = "registrationCode")
    CompanyInfo toCompanyDto(Company company);


}