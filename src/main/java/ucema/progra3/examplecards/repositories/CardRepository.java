package ucema.progra3.examplecards.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ucema.progra3.examplecards.model.Card;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

    List<Card> findByBank_Name(String name);

    List<Card> findByCustomer_Username(String username);

}
