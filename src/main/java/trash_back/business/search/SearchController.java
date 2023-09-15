package trash_back.business.search;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trash_back.business.product.dto.material.ProductMaterialDto;
import trash_back.business.search.dto.ProductSearchResultByUpc;

import java.util.List;

@RestController
@RequestMapping("/search/")
public class SearchController {

    @Resource
    private SearchService searchService;

    //todo  this seach must send a requst by material name in the future
    @GetMapping("material")
    @Operation(summary = "find all recycling information", description = " input is upc ")
    public List<ProductMaterialDto> productRecyclingProfile(@RequestParam String upc) {
        return searchService.getProductProfileBy(upc);
    }

    @GetMapping("product")
    @Operation(summary = "find and display infomation regarding a products recycling info", description = " take in " +
            "product upc")
    public ProductSearchResultByUpc productCommercialProfile(@RequestParam String upc) {
        return searchService.getProductInfoBy(upc);
    }

}
