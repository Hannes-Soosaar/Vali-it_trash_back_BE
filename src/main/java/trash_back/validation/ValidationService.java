package trash_back.validation;

import trash_back.domain.product.Product;
import trash_back.domain.product.material.Material;
import trash_back.domain.user.User;
import trash_back.infrastructure.exception.BusinessException;
import trash_back.infrastructure.exception.DataNotFoundException;

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

    public static Product getValidProduct(Optional<Product> optionalProduct) {
        if (optionalProduct.isEmpty()) {
            throw new DataNotFoundException("Toode puudub andmebaasist", 555);
        }
        return optionalProduct.get();
    }

    public static Material getValidMaterial(Optional<Material> optionalMaterial) {
        if (optionalMaterial.isEmpty()) {
            throw new DataNotFoundException("Materjal puudub andmebaasist", 666);
        }
        return optionalMaterial.get();
    }
}
