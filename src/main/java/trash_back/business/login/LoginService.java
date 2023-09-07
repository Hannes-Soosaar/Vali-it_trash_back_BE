package trash_back.business.login;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.domain.user.User;
import trash_back.domain.user.UserService;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;
    public void login(String username, String password) {

        User user = userService.findActiveUserBy(username, password);
        userMapper.toLoginResponse(user);

    }
}
