package trash_back.business.company.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trash_back.domain.user.User;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest implements Serializable {
    @NotNull
    @Size(max = 255)
    private String email;
    @NotNull
    @Size(max = 30)
    private String password;

    @NotNull
    @Size(max = 255)
    private String companyName;

    @NotNull
    @Size(max = 20)
    private int registrationCode;

}