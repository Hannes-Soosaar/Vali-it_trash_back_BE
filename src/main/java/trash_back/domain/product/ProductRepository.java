package trash_back.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.company.id = ?1 order by p.name")
    List<Product> findProductsBy(Integer companyId);

    @Query("select p from Product p where p.upc = ?1")
    Optional<Product> findProductBy(String upc);

    @Query("select p from Product p where p.id = ?1")
    Product findProductBy(Integer productId);



}