package trash_back.domain.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import trash_back.domain.company.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("select c from Company c where c.user.id = ?1")
    Company findCompanyInfoBy(Integer userId);


}