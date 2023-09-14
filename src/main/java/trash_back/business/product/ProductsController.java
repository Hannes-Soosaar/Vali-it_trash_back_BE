package trash_back.business.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import trash_back.business.product.dto.ProductProfile;
import trash_back.business.product.dto.ProductRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trash_back.domain.product.ProductService;
import trash_back.infrastructure.error.ApiError;

import java.util.List;

@RestController
public class ProductsController {

    @Resource
    private ProductsService productsService;

    @Resource
    private ProductService productService;

    @GetMapping("/products")
    @Operation(summary = "tagastab toote profiili ja vastava tooted materjalid",
            description = "companyId järgi saab kätte tooteprofiili; juurde lisatud materjali id, nimi ja kategooria nimi")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi toodet",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<ProductProfile> getProductProfile(@RequestParam Integer companyId) {
        List<ProductProfile> productProfiles = productsService.getProductProfile(companyId);
        return productProfiles;
    }

    @PostMapping("/products")
    @Operation(summary = "Uue toote lisamine", description = "toote nimetus, upc, lisainfo, staatus, pilt")
    public void addProductProfile(@RequestBody ProductRequest productRequest) {
        productsService.addProductProfile(productRequest);
    }

    @DeleteMapping("/products")
    @Operation(summary = "Toote kustutamine", description = "muudab toote staatuse D ehk mitteaktiivseks. Ei kustuta andmebaasist! ")
    public void deleteProductProfile(@RequestParam Integer productId) {
        productsService.deleteProductProfile(productId);

    }




}
