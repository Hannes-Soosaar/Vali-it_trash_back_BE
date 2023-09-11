package trash_back.business.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trash_back.infrastructure.error.ApiError;

import java.util.List;

@RestController
public class ProductsController {

    @Resource
    private ProductsService productsService;

    @GetMapping("/products")
    @Operation(summary = "tagastab toote profiili",
            description = "companyId järgi saab konkreets toote kätte")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi toodet",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})

    public List<ProductProfile> getProductProfile(@RequestParam Integer companyId) {
        List<ProductProfile> productProfiles = productsService.getProductProfile(companyId);
        return productProfiles;
    }
}
