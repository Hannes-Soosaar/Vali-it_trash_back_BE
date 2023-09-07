package trash_back.business.login;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trash_back.domain.user.LoginResponse;

@RestController
public class LoginController {

    @Resource
   private LoginService loginService;

    @GetMapping("/login")

    public LoginResponse login(@RequestParam String email, @RequestParam String password) {


        LoginResponse loginResponse = loginService.login(email, password);
        return loginResponse;
    }


}
