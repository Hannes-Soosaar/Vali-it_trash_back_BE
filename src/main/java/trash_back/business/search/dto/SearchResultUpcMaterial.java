package trash_back.business.search.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trash_back.domain.product.material.ProductMaterial;

import java.io.Serializable;

/**
 * DTO for {@link ProductMaterial}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResultUpcMaterial implements Serializable {


    private String materialBinColorName;
    private String materialBinName;
    private String materialName;
}