package trash_back.domain.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("select c from Company c where c.user.id = ?1")
    Company findCompanyInfoBy(Integer userId);

    @Query("select (count(c) > 0) from Company c where c.name = ?1")
    boolean companyNameExistsByName(String name);


}