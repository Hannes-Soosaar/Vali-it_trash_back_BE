package trash_back.business.login;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trash_back.domain.user.UserDto;

@RestController
public class LoginController {

    @Resource
   private LoginService loginService;

    @GetMapping("/login")

    public UserDto login(@RequestParam String username, @RequestParam String password) {
        UserDto userDto = loginService.login(username, password);
        return userDto;
    }


}
