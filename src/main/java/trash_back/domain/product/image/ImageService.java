package trash_back.domain.product.image;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.domain.ImageRepository;

@Service
public class ImageService {

    @Resource
    private ImageRepository imageRepository;

    public void saveImage(Image image) {
        imageRepository.save(image);
    }
}
