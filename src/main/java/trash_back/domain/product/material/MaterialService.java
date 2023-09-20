package trash_back.domain.product.material;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.validation.ValidationService;

import java.util.Optional;

@Service
public class MaterialService {

    @Resource
    private MaterialRepository materialRepository;


    public Material getValidMaterialBy(String materialName) {
        Optional<Material> optionalMaterial = materialRepository.findMaterialBy(materialName);
        return ValidationService.getValidMaterial(optionalMaterial);

    }

    public Material getMaterialBy(Integer materialId) {
        return materialRepository.getReferenceById(materialId);
    }
}

