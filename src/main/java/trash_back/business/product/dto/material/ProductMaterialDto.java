package trash_back.business.product.dto.material;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trash_back.domain.product.productmaterial.ProductMaterial;

import java.io.Serializable;

/**
 * DTO for {@link ProductMaterial}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMaterialDto implements Serializable {
    private Integer productMaterialId;
    private String materialCategoryName;
    private String materialBinColorName;
    private String materialBinName;
    private String materialBinRequirements;
    private String materialName;
}