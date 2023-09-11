package trash_back.business.materials;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductMaterialsController {

    @Resource
    private ProductMaterialsService productMaterialsService;

    public void ProductMaterialsService(Integer productId){
        //Return ProductMaterial List


    }



}
