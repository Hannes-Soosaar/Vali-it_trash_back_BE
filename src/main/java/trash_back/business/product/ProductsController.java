package trash_back.business.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import trash_back.business.product.dto.ImageRequest;
import trash_back.business.product.dto.ProductProfile;
import trash_back.business.product.dto.ProductRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trash_back.business.product.dto.ProductBasicProfile;
import trash_back.business.product.image.ImageResponse;
import trash_back.domain.product.ProductResponse;
import trash_back.domain.product.productmaterial.ProductMaterialService;
import trash_back.infrastructure.error.ApiError;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Resource
    private ProductsService productsService;


    @GetMapping
    @Operation(summary = "tagastab toodete profiilid ja toodete materjalid",
            description = "companyId järgi saab kätte tooteprofiili(d); juurde lisatud materjali id, nimi ja kategooria nimi")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi toodet",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<ProductProfile> getProductProfiles(@RequestParam Integer companyId) {
        return productsService.getProductProfiles(companyId);
    }

    @GetMapping("/product")
    @Operation(summary = "tagastab tooteprofiili ja toote materjalid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi toodet",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public ProductProfile getProductProfile(@RequestParam Integer productId) {
        return productsService.getProductProfile(productId);
    }


    @PostMapping
    @Operation(summary = "Uue toote lisamine", description = "toote nimetus, upc, lisainfo, staatus, pilt")
    public ProductResponse addProductProfile(@RequestBody ProductRequest productRequest) {
        return productsService.addProductProfile(productRequest);
    }

    @DeleteMapping
    @Operation(summary = "Toote kustutamine", description = "muudab toote staatuse D ehk mitteaktiivseks. Ei kustuta andmebaasist! ")
    public void deleteProductProfile(@RequestParam Integer productId) {
        productsService.deleteProductProfile(productId);

    }

    @PutMapping
    @Operation(summary = "Toote muutmine", description = "productId abil muudab product tabelis andmeid")
    public void updateProductProfile(@RequestParam Integer productId, @RequestBody ProductBasicProfile productRequest) {
        productsService.updateProductProfile(productId, productRequest);
    }

    @PutMapping("/product-image")
    @Operation(summary = "tootele pildi muutmine", description = "toote id alusel laetakse ylsesse imageData")
    public void modifyProductPicture(@RequestParam Integer productId, @RequestBody ImageRequest imageRequest) {
        productsService.modifyProductPicture(productId, imageRequest);
    }

    @GetMapping("/product-get-image")
    @Operation(summary = "toob ära productId järgi toote pildi")
    public ImageResponse getProductImage(@RequestParam Integer productId) {
        return productsService.getProductImage(productId);

    }



}
