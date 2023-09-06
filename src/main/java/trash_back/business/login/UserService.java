package trash_back.business.login;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.UserRepository;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;


    public void findActiveUserBy(String username, String password) {

    userRepository.findUserBy(username, password, Status.ACTIVE.getLetter());

    }
}
