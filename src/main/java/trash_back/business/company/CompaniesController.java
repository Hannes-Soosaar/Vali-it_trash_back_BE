package trash_back.business.company;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import trash_back.business.company.dto.CompanyInfo;
import trash_back.business.company.dto.CompanyRequest;
import trash_back.infrastructure.error.ApiError;

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
    @Operation(summary = "Uue kasutaja registreerimine",
            description = """
                Sisse tuleb email, parool, ettevõtte nimi ja ettevõtte reg nr. Need salvestatakse andmebaasi.""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "", description = "",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})

    public void addUserAndCompany(@RequestBody CompanyRequest companyRequest) {

        companiesService.addUserAndCompany(companyRequest);
    }
}
