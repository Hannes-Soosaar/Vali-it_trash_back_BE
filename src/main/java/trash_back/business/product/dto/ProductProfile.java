package trash_back.business.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trash_back.domain.product.Product;

import java.io.Serializable;

/**
 * DTO for {@link Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductProfile implements Serializable {
    private Integer id;
    private Integer imageId;
    private String imageData;
    private String companyName;
    private String upc;
    private String productInfo;
    private String status;
}