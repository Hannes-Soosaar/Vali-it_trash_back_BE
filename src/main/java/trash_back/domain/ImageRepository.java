package trash_back.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import trash_back.domain.product.image.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}