package trash_back.domain.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordRequest implements Serializable {
    @NotNull
    @Size(max = 30)
    private String oldPassword;
    @NotNull
    @Size(max = 30)
    private String newPassword;
    @NotNull
    private Integer userId;


}