package trash_back.business;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class productSearchController {

    @Resource
    private ProductService productService;

    @GetMapping("/productSearch")

    public void getProductProfile(@RequestParam String upc) {

        productService.getProductProfile(upc);

    }









}
