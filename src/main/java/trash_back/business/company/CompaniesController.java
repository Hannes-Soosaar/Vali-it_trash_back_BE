package trash_back.business.company;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trash_back.domain.CompanyDto;

@RestController
public class CompaniesController {

    @Resource
    private CompaniesService companiesService;

    @GetMapping ("/company/info")

    public CompanyDto getCompanyInfo(@RequestParam Integer userId){

        CompanyDto companyDto = companiesService.getCompanyInfo(userId);
        return companyDto;
    }
}
