package trash_back.business.search;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trash_back.business.product.dto.material.ProductMaterialDto;

import java.util.List;

@RestController
public class SearchController {


    @Resource
    private SearchService searchService;


    @GetMapping("/search-result")
    public List<ProductMaterialDto> productRecyclingProfile(@RequestParam String upc){
            return searchService.getProductProfileBy(upc);
    }


    @GetMapping("/search")

    public void searchProductAndRecyclingInfo(@RequestParam String upc) {
        searchService.searchProductAndRecyclingInfo(upc);
    }


}
