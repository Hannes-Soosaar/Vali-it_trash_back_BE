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
    private final UserRepository userRepository;
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

    public CompaniesService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CompanyInfo getCompanyInfo(Integer userId) {
        Company company = companyService.getCompanyBy(userId);
        return companyMapper.toCompanyInfo(company);
    }

    @Transactional
    public void addUserAndCompany(CompanyRequest companyRequest) {
        userService.validateEmailIsAvailable(companyRequest.getEmail());
        companyService.validateCompanyNameIsAvailable(companyRequest.getCompanyName());
        Role role = roleService.getRoleUser();
        User user = userMapper.toUser(companyRequest);
        user.setRole(role);
        userService.saveUser(user);
        Company company = companyMapper.toCompany(companyRequest);
        company.setUser(user);
        companyService.saveCompany(company);
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
