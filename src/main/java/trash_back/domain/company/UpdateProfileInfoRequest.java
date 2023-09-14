package trash_back.domain.company;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Company}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfileInfoRequest implements Serializable {

    @NotNull
    private Integer userId;
    @NotNull
    @Size(max = 255)
    private String name;
    @NotNull
    private Integer registrationcode;
}