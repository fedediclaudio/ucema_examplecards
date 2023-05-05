package ucema.progra3.examplecards.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucema.progra3.examplecards.model.Role;
import ucema.progra3.examplecards.model.User;
import ucema.progra3.examplecards.repositories.RoleRepository;
import ucema.progra3.examplecards.repositories.UserRepository;
import ucema.progra3.examplecards.services.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Role createRole(Role role) {
        return this.roleRepository.save(role);
    }
}
