package trash_back.business.product.material;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trash_back.business.product.dto.material.ProductMaterialDto;
import trash_back.infrastructure.error.ApiError;

import java.util.List;

@RestController
public class MaterialsController {


    // All request from materials and down.
    @Resource
    private ProductMaterialsService productMaterialsService;

    @GetMapping("/product-materials")
    @Operation(summary = "Materjalide otsimine ProductId järgi")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellist toodet ei ole olemas",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})

// get is used as there can not be a product without a material
    public List<ProductMaterialDto> getProductMaterials(@RequestParam Integer productId) {
        return productMaterialsService.getProductMaterials(productId);

    }


}
