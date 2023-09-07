package trash_back.domain.user;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "role.name", target = "roleName")
    @Mapping(source = "id", target = "userId")
    LoginResponse toLoginResponse(User user);

}