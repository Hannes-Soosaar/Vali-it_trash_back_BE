package trash_back.domain.product.image;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Override
    Optional<Image> findById(Integer integer);
}