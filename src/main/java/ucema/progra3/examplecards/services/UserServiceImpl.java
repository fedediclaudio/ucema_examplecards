package ucema.progra3.examplecards.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ucema.progra3.examplecards.authentication.JwtUtilities;
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

    @Autowired
    private JwtUtilities jwtUtilities;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager ;

    @Override
    public User createUser(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password)); //Se debe establecer la contraseña cifrada.
        return this.userRepository.save(user);
    }

    @Override
    public Role createRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public boolean checkUserById(Long id) {
        return this.userRepository.existsById(id);
    }

    @Override
    public String authenticate(String username, String password) {
        User user = this.userRepository.findByUsername(username).orElse(null);
        if (user == null) { return null; }
        // Generar el token a retornar
        String token = jwtUtilities.generateToken(user.getUsername(), user.getId(), user.getRole().getName());
        return token;

        // ACLARACION: Solo estoy retornando el JWT, el usuario no esta actualmente autenticado
        // por lo que si voy a realizar otra tarea debo generar el objeto correspondiente y
        // agregarlo al contexto de Spring

    }

    @Override
    public User getUserInfo() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.userRepository.findByUsername(username).orElse(null);
    }


}
