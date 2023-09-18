package trash_back.business.product.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link trash_back.domain.product.Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponse implements Serializable {
    private String imageData;
}