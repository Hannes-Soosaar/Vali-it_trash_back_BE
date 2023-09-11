package trash_back.business.materials;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProductMaterialsService {

    @Resource
    private ProductMateialService productMateialService;

    @Resource
    private ProductMaterialMapper   productMaterialMapper;

    public void getProductMaterials(Integer ProductId){

    }




}
