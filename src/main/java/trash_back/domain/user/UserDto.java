package trash_back.domain.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Value
public class UserDto implements Serializable {
    @NotNull
    Integer companyId;
    @NotNull
    @Size(max = 255)
    String email;
    @NotNull
    @Size(max = 30)
    String password;
}