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

// TODO: 07.09.2023 tee errori enumid error koodist 

    }

    public static void validateEmailIsAvailable(boolean userExists) {
        if (userExists) {
            throw new BusinessException("Selline email on juba kasutusel", 222);
        }
    }

    public static void validateCompanyNameIsAvailable(boolean companyNameExists) {
        if (companyNameExists) {
            throw new BusinessException("Sellise nimega ettevõte on juba olemas", 333);
        }
    }

    public static void validatePasswordChangeAllowed(boolean passwordChangeAllowed) {
        if (!passwordChangeAllowed) {
            throw new BusinessException("Sisestatud vana parool ei ole õige", 444);
        }
    }
}
