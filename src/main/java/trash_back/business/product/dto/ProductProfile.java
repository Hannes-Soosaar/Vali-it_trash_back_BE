package trash_back.business.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trash_back.business.product.dto.material.MaterialInfo;
import trash_back.domain.product.Product;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductProfile implements Serializable {
    private Integer productId;
    private String imageData;
    private String productName;
    private String upc;
    private String productInfo;
    private String status;
    private List <MaterialInfo> materials;
}