package trash_back.business.company;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.domain.Company;
import trash_back.domain.CompanyRepository;

@Service
public class CompanyService {
    @Resource
    private CompanyRepository companyRepository;
    public Company getCompanyBy(Integer userId) {

        Company company = companyRepository.findCompanyInfoBy(userId);
        return company;

    }
}
