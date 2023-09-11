package trash_back.domain.company;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import trash_back.business.company.dto.CompanyInfo;
import trash_back.business.company.dto.CompanyRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-11T13:04:03+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyInfo toCompanyInfo(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyInfo companyInfo = new CompanyInfo();

        companyInfo.setCompanyId( company.getId() );
        companyInfo.setCompanyName( company.getName() );
        companyInfo.setRegistrationCode( company.getRegistrationcode() );

        return companyInfo;
    }

    @Override
    public Company toCompany(CompanyRequest companyRequest) {
        if ( companyRequest == null ) {
            return null;
        }

        Company company = new Company();

        company.setName( companyRequest.getCompanyName() );
        company.setRegistrationcode( companyRequest.getRegistrationCode() );

        return company;
    }
}
