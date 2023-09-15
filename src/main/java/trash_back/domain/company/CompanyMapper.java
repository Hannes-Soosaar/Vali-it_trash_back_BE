package trash_back.domain.company;

import org.mapstruct.*;
import trash_back.business.company.dto.CompanyInfo;
import trash_back.business.company.dto.CompanyRequest;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {

    @Mapping(source = "id", target = "companyId")
    @Mapping(source = "name", target = "companyName")
    @Mapping(source = "registrationcode", target = "registrationCode")
    CompanyInfo toCompanyInfo(Company company);
    @Mapping(source = "companyName", target = "name")
    @Mapping(source = "registrationCode", target = "registrationcode")
    Company toCompany(CompanyRequest companyRequest);

}