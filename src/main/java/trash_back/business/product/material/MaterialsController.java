package trash_back.business.product.material;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trash_back.business.product.dto.material.ProductMaterialDto;
import trash_back.business.product.dto.CategoryDto;
import trash_back.business.product.dto.MaterialNameDto;
import trash_back.infrastructure.error.ApiError;

import java.util.List;

@RestController
public class MaterialsController {
    @Resource
    private ProductMaterialsService productMaterialsService;


    @GetMapping("/product-materials")
    @Operation(summary = "Materjalide otsimine ProductId järgi")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellist toodet ei ole olemas",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<ProductMaterialDto> getProductMaterials(@RequestParam Integer productId) {
        return productMaterialsService.getProductMaterials(productId);
    }

    @GetMapping("/categories")
    @Operation(summary = "Toob ära kõik materjalide kategooriad", description = "toob ära nii materialId kui ka materialName")
    public List<CategoryDto> getCategoryNames() {
        List<CategoryDto> categoryNames = productMaterialsService.getCategoryNames();
        return categoryNames;
    }

    @GetMapping("/material-names")
    @Operation(summary = "Toob categoryId järgi ära materjalide nimetused")
    public List<MaterialNameDto> getMaterialNames(@RequestParam Integer categoryId) {
        List<MaterialNameDto> materialNames = productMaterialsService.getMaterialNames(categoryId);
        return materialNames;
    }

    @DeleteMapping("/product-materials")
    @Operation(summary = "Kustutab product_materials tabelist seose")
    public void deleteProductMaterial(@RequestParam Integer productMaterialId){
        productMaterialsService.deleteProductMaterial(productMaterialId);
    }

}
