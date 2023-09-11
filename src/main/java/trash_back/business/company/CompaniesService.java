package trash_back.business.company;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.domain.company.Company;
import trash_back.domain.company.CompanyMapper;
import trash_back.domain.company.CompanyService;

@Service
public class CompaniesService {

@Resource
private CompanyService companyService;

@Resource
private CompanyMapper companyMapper;

    public CompanyInfo getCompanyInfo(Integer userId) {
        Company company = companyService.getCompanyBy(userId);
        CompanyInfo companyInfo = companyMapper.toCompanyDto(company);
        return companyInfo;


    }
}
