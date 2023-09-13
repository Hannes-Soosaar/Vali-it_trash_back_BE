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
import trash_back.domain.user.UpdatePasswordRequest;
import trash_back.infrastructure.error.ApiError;

@RestController
@RequestMapping("/company")
public class CompaniesController {

    @Resource
    private CompaniesService companiesService;

    @GetMapping("/info")
    @Operation(summary = "User Id järgi otsitakse ettevõtte andmeid.",
            description = "Otsitavad andmed companyId, companyName ja registration code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "", description = "",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public CompanyInfo getCompanyInfo(@RequestParam Integer userId) {

        CompanyInfo companyInfo = companiesService.getCompanyInfo(userId);
        return companyInfo;
    }

    @PostMapping
    @Operation(summary = "Uue aktiivse kasutaja registreerime koos ettevõttega",
            description = "Sisse tuleb email, parool, ettevõtte nimi ja ettevõtte reg nr. Need salvestatakse andmebaasi.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Kasutaja email on juba olemas",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})

    public void addUserAndCompany(@RequestBody CompanyRequest companyRequest) {

        companiesService.addUserAndCompany(companyRequest);
    }

//    @PutMapping("/user")
//
//
//    public void updatePassword(@RequestParam Integer userId, String oldPassword, String newPassword) {
//        companiesService.updatePassword(userId, oldPassword, newPassword);
//    }


    @PatchMapping("/password")

    public void updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        companiesService.updatePassword(updatePasswordRequest);
    }
}
