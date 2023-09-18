package trash_back.domain.product.material;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    @Query("select m from Material m where upper(m.name) = upper(?1)")
    Optional<Material> findMaterialBy(String name);

}