package trash_back.business.login;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;
    public void login(String username, String password) {

    userService.findActiveUserBy(username,password);
    }
}
