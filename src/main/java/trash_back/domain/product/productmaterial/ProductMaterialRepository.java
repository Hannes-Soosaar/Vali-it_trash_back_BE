package trash_back.domain.product.productmaterial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductMaterialRepository extends JpaRepository<ProductMaterial, Integer> {
    @Query("select p from ProductMaterial p where p.product.id = ?1")
    List<ProductMaterial> findProductMaterialBy(Integer productId);
}