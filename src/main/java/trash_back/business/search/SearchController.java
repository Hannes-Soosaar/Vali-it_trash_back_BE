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
import trash_back.business.product.dto.material.ProductMaterialDto;
import trash_back.infrastructure.error.ApiError;
import trash_back.business.search.dto.ProductSearchResultByUpc;

import java.util.List;

@RestController
@RequestMapping("/search/")
public class SearchController {

    @Resource
    private SearchService searchService;

    @GetMapping("material")
    public List<ProductMaterialDto> productRecyclingProfile(@RequestParam String upc) {
        return searchService.getProductProfileBy(upc);
    }

    @GetMapping("product")
    public ProductSearchResultByUpc productCommercialProfile(@RequestParam String upc) {
        return searchService.getProductInfoBy(upc);
    }

}
