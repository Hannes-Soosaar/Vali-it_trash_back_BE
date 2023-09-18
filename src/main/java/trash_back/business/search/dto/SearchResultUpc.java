package trash_back.business.search.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trash_back.domain.product.Product;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResultUpc implements Serializable {

    private Integer productId;
    private String productName;
    private String productInfo;
    private String imageData;
    private List<SearchResultUpcMaterial> materials ;
}