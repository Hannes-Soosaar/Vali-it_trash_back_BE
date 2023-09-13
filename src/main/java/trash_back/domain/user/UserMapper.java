package trash_back.domain.user;

import org.mapstruct.*;
import trash_back.business.company.dto.CompanyRequest;
import trash_back.business.login.LoginResponse;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {


    @Mapping(source = "role.name", target = "roleName")
    @Mapping(source = "id", target = "userId")
    LoginResponse toLoginResponse(User user);


    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(constant = "A", target = "status")
    User toUser(CompanyRequest companyRequest);


    @Mapping(source = "newPassword", target = "password")
    User toUserPassword(UpdatePasswordRequest updatePasswordRequest);
}