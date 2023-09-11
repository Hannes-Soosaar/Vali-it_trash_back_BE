package trash_back.domain.company;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import trash_back.business.company.CompanyInfo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-07T13:22:22+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyInfo toCompanyDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyInfo companyInfo = new CompanyInfo();

        companyInfo.setCompanyId( company.getId() );
        companyInfo.setCompanyName( company.getName() );
        companyInfo.setRegistrationCode( company.getRegistrationcode() );

        return companyInfo;
    }
}
