package trash_back.business.search.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trash_back.domain.company.Company;
import trash_back.domain.product.Product;
import trash_back.domain.product.image.Image;

import java.io.Serializable;

/**
 * DTO for {@link Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchResultByUpc implements Serializable {
    @NotNull
    private String companyName;
    private String imageData;
    @NotNull
    @Size(max = 255)
    private String name;
    @NotNull
    @Size(max = 255)
    private String info;
}