package ucema.progra3.examplecards.services.interfaces;

import ucema.progra3.examplecards.model.Role;
import ucema.progra3.examplecards.model.User;

public interface IUserService {

    User createUser(User user);
    Role createRole(Role role);
    boolean checkUserById(Long id);
    String authenticate(String username, String password);
}
