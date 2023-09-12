package trash_back.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import trash_back.domain.product.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.company.id = ?1 order by p.name")
    List<Product> findProductsBy(Integer companyId);

}