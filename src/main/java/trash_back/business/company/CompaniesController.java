package trash_back.business.company;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import trash_back.business.company.dto.CompanyInfo;
import trash_back.business.company.dto.CompanyRequest;

@RestController
public class CompaniesController {

    @Resource
    private CompaniesService companiesService;

    @GetMapping("/company/info")

    public CompanyInfo getCompanyInfo(@RequestParam Integer userId) {

        CompanyInfo companyInfo = companiesService.getCompanyInfo(userId);
        return companyInfo;
    }

    @PostMapping("/company")

    public void addUserAndCompany(@RequestBody CompanyRequest companyRequest) {

        companiesService.addUserAndCompany(companyRequest);
    }
}
