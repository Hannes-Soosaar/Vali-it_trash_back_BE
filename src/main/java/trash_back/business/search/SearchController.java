package trash_back.business.search;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trash_back.business.search.dto.SearchResultUpc;
import trash_back.business.search.dto.SearchResultMaterial;
import trash_back.infrastructure.error.ApiError;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Resource
    private SearchService searchService;

//    @GetMapping("material")
//    public List<ProductMaterialDto> productRecyclingProfile(@RequestParam String upc) {
//        return searchService.getProductProfileBy(upc);
//    }


    //    @GetMapping("product")
//    public ProductSearchResultByUpc productCommercialProfile(@RequestParam String upc) {
//        return searchService.getProductInfoBy(upc);
//    }


    @GetMapping("/product")
    @Operation(summary = "Toote info ja sorteerimisjuhiste otsimine UPC järgi",
            description = "tagastab productId, toote nime, toote info, pildi, prügikasti nime, värvi ja materjalinime ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Toode puudub andmebaasist",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public SearchResultUpc searchProductAndRecyclingInfo(@RequestParam String upc) {
       return searchService.searchProductAndRecyclingInfo(upc);


    }

    @GetMapping("/material")
    @Operation(summary = "Materjali nime järgi otsimine",
            description = "Otsing tagastab materjalitüübi, prügikasti nime, prügikasti värvi ja prügikasti info. Pilt tuleb frontist.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Materjal puudub andmebaasist",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})

    public SearchResultMaterial searchMaterialInfo (@RequestParam String materialName) {
        return searchService.searchMaterialInfo(materialName);
    }

}
