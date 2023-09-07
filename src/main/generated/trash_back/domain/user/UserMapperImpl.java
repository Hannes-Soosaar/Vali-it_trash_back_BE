package trash_back.domain.user;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import trash_back.business.login.LoginResponse;
import trash_back.domain.Role;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-07T10:20:29+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public LoginResponse toLoginResponse(User user) {
        if ( user == null ) {
            return null;
        }

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setRoleName( userRoleName( user ) );
        loginResponse.setUserId( user.getId() );

        return loginResponse;
    }

    private String userRoleName(User user) {
        if ( user == null ) {
            return null;
        }
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        String name = role.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
