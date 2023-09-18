package trash_back.business.product.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class ProductBasicProfile implements Serializable {
    @NotNull
    @Size(max = 255)
    private String productName;
    @NotNull
    @Size(max = 14)
    private String upc;
    @Size(max = 255)
    private String productInfo;
}