package trash_back.business.search.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trash_back.domain.product.material.bin.Bin;

import java.io.Serializable;

/**
 * DTO for {@link Bin}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResultMaterial implements Serializable {
    private String binName;
    private String binColor;
    private String binRequirements;
}