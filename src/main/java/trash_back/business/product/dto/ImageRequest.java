package trash_back.business.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trash_back.domain.product.image.Image;

import java.io.Serializable;

/**
 * DTO for {@link Image}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageRequest implements Serializable {

    private String  imageData;
}