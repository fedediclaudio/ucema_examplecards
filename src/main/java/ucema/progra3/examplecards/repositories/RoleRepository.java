package ucema.progra3.examplecards.repositories;

import org.springframework.data.repository.CrudRepository;
import ucema.progra3.examplecards.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
