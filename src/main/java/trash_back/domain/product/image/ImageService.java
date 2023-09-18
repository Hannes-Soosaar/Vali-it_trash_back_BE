package trash_back.domain.product.image;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.infrastructure.exception.BusinessException;

import java.util.Optional;

@Service
public class ImageService {

    @Resource
    private ImageRepository imageRepository;

    public Image getImageData(Integer productId) {
        Optional<Image> image = imageRepository.findById(productId);
        if (!image.isEmpty()) {
            return image.get();
        } else {
            throw new BusinessException("Pilt puudub", 555);
        }
    }

    public void saveImage(Image image) {
        imageRepository.save(image);
    }

}
