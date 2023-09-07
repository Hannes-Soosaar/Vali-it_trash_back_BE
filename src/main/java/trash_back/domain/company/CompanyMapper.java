package trash_back.domain.company;

import org.mapstruct.*;
import trash_back.business.company.CompanyInfo;
import trash_back.domain.company.Company;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {

    @Mapping(source = "id", target = "companyId")
    @Mapping(source = "name", target = "companyName")
    @Mapping(source = "registrationcode", target = "registrationCode")
    CompanyInfo toCompanyDto(Company company);


}