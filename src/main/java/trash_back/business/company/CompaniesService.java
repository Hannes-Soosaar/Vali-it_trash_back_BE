package trash_back.business.company;


import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import trash_back.business.company.dto.CompanyInfo;
import trash_back.business.company.dto.CompanyRequest;
import trash_back.domain.company.Company;
import trash_back.domain.company.CompanyMapper;
import trash_back.domain.company.CompanyService;
import trash_back.domain.company.UpdateProfileInfoRequest;
import trash_back.domain.role.Role;
import trash_back.domain.role.RoleService;
import trash_back.domain.user.*;

@Service
public class CompaniesService {

    @Resource
    private CompanyService companyService;

    @Resource
    private RoleService roleService;


    @Resource
    private UserService userService;

    @Resource
    private CompanyMapper companyMapper;

    @Resource
    private UserMapper userMapper;
    private final UserRepository userRepository;

    public CompaniesService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CompanyInfo getCompanyInfo(Integer userId) {
        Company company = companyService.getCompanyBy(userId);
        CompanyInfo companyInfo = companyMapper.toCompanyInfo(company);
        return companyInfo;


    }


    @Transactional
    public void addUserAndCompany(CompanyRequest companyRequest) {
        // TODO: 11.09.2023 kontrolli kõigepealt , kas emaili nimi on hõivatud, kui jah viska viga.

        userService.validateEmailIsAvailable(companyRequest.getEmail());

        // TODO: 11.09.2023 kontrolli  , kas ettevõtte nimi on hõivatud, kui jah viska viga.

        companyService.validateCompanyNameIsAvailable(companyRequest.getCompanyName());


        // TODO: 11.09.2023 Otsi ylesse roll "user".  RoleService -> RoleRepository (useri roleid on 2)
        Role role = roleService.getRoleUser();
        // user mapperi abil tekitad uue user objekti, saad ära täita väljad email, password ja status
        User user = userMapper.toUser(companyRequest);

        // nüüd saad user objektile panna külge setteri abil rolli
        user.setRole(role);
        // nüüd saad useri ära salvestada (userService --> userRepository)
        userService.saveUser(user);

        //


        // TODO: 11.09.2023 companyMapperi abil tekitad uue company objekti. Dtost mapid ära nii palju andmeid kui saad
        Company company = companyMapper.toCompany(companyRequest);
        // nüüd saad company objektile panna külge user objekti(foreign key)
        company.setUser(user);
        // nüüd saad company objekti ära salvestada andmebaasi(companyService -> companyRepository)
        companyService.saveCompany(company);

        // finito

    }

    public void updatePassword(UpdatePasswordRequest request) {
        userService.validatePasswordChangeAllowed(request.getUserId(), request.getOldPassword());
        User user = userService.getUserBy(request.getUserId());
        user.setPassword(request.getNewPassword());
        userService.saveUser(user);
    }

    public void updateProfileInfo(UpdateProfileInfoRequest updateProfileInfoRequest) {
        Company company = companyService.getCompanyBy(updateProfileInfoRequest.getUserId());
        company.setName(updateProfileInfoRequest.getName());
        company.setRegistrationcode(updateProfileInfoRequest.getRegistrationcode());
        companyService.saveCompany(company);
    }
}
