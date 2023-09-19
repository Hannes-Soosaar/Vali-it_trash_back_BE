package trash_back.business.product.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trash_back.domain.product.material.Material;

import java.io.Serializable;

/**
 * DTO for {@link Material}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialNameDto implements Serializable {
    private Integer materialId;
    @NotNull
    @Size(max = 255)
    private String materialName;
}