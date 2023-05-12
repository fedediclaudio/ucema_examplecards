package ucema.progra3.examplecards.repositories;

import org.springframework.data.repository.CrudRepository;
import ucema.progra3.examplecards.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
