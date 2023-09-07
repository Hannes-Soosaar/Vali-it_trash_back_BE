package trash_back.business.login;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.domain.user.User;
import trash_back.domain.user.UserDto;
import trash_back.domain.user.UserMapper;
import trash_back.domain.user.UserService;

@Service
public class LoginService {



    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public UserDto login(String username, String password) {

        User user = userService.findActiveUserBy(username, password);
        UserDto userDto = userMapper.toUserDto(user);
        return userDto;

    }
}
