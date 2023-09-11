package trash_back.domain.role;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class RoleService {
    @Resource
    private RoleRepository roleRepository;


    public Role getRoleUser() {
        return roleRepository.getReferenceById(2);
    }
}
