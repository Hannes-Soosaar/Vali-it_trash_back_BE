package trash_back.validation;

import trash_back.domain.user.User;
import trash_back.infrastructure.exception.BusinessException;

import java.util.Optional;

public class ValidationService {


    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException("vale kasutajanimi või parool", 111);
        }
        return optionalUser.get();



    }
}
