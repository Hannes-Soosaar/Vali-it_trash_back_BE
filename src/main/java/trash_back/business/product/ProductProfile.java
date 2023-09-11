package trash_back.business.product;

import jakarta.validation.constraints.NotNull;
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
    private Integer productId;
    @NotNull
    private String productName;
    @NotNull
    private String productUpc;
    private String productInfo;
    @NotNull
    private String productStatus;
}