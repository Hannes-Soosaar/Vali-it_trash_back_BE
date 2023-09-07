package trash_back.domain.company;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Resource
    private CompanyRepository companyRepository;
    public Company getCompanyBy(Integer userId) {

        Company company = companyRepository.findCompanyInfoBy(userId);
        return company;

    }
}
