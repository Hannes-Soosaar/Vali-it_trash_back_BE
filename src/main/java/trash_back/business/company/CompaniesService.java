package trash_back.business.company;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.domain.Company;
import trash_back.domain.CompanyDto;
import trash_back.domain.CompanyMapper;

@Service
public class CompaniesService {

    @Resource
    private CompanyService companyService;

    @Resource
    private CompanyMapper companyMapper;

    public CompanyDto getCompanyInfo(Integer userId) {
        Company company = companyService.getCompanyBy(userId);
        CompanyDto companyDto = companyMapper.toCompanyDto(company);
        return companyDto;

    }
}
