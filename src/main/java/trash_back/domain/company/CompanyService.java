package trash_back.domain.company;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.validation.ValidationService;

@Service
public class CompanyService {

    @Resource
    private CompanyRepository companyRepository;

    public Company getCompanyBy(Integer userId) {
        return companyRepository.findCompanyInfoBy(userId);
    }

    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    public void validateCompanyNameIsAvailable(String companyName) {
        boolean companyNameExists = companyRepository.companyNameExistsByName(companyName);

        ValidationService.validateCompanyNameIsAvailable(companyNameExists);

    }
}
