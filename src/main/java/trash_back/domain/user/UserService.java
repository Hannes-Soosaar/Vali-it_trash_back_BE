package trash_back.domain.user;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import trash_back.business.login.Status;
import trash_back.validation.ValidationService;

import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;


    public User findActiveUserBy(String email, String password) {


        Optional<User> optionalUser = userRepository.findActiveUserBy(email, password, Status.ACTIVE.getLetter());
        User user = ValidationService.getValidUser(optionalUser);
        return user;


    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void validateEmailIsAvailable(String email) {

        boolean userExists = userRepository.userExistsBy(email);

        ValidationService.validateEmailIsAvailable(userExists);
    }

    public User getUserBy(Integer userId) {
        return userRepository.getReferenceById(userId);
    }

    public void validatePasswordChangeAllowed(Integer userId, String oldPassword) {
        boolean passwordChangeAllowed = userRepository.userExistsBy(userId, oldPassword);

        ValidationService.validatePasswordChangeAllowed(passwordChangeAllowed);

    }


//    public User getPassword(Integer userId) {
//        User password = userRepository.getReferenceById(userId);
//        return password;
//    }


}
