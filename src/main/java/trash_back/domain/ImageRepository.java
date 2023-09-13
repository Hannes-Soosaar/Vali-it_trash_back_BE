package trash_back.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import trash_back.domain.product.image.Image;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Override
    Optional<Image> findById(Integer integer);
}