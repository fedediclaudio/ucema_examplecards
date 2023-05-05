package ucema.progra3.examplecards.repositories;

import org.springframework.data.repository.CrudRepository;
import ucema.progra3.examplecards.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
