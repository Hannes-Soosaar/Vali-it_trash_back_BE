package trash_back.business.company;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompaniesController {

    @Resource
    private CompaniesService companiesService;

    @GetMapping ("/company/info")

    public CompanyInfo getCompanyInfo(@RequestParam Integer userId) {

        CompanyInfo companyInfo = companiesService.getCompanyInfo(userId);
        return companyInfo;
    }

}
