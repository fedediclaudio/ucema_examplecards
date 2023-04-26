package ucema.progra3.examplecards.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ucema.progra3.examplecards.model.Bank;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankRepository extends CrudRepository<Bank, Long> {

    Optional<Bank> findByName(String name);

    List<Bank> findByTotalSpentGreaterThanEqual(float spent);

    Optional<Bank> findByCards_Number(String number);

    @Query("from Bank where size(cards) = 0")
    List<Bank> findByWithoutCards();

    @Query(value = "select b.* from bank b left join card c on (b.id_bank = c.id_bank) where c.id_bank is null",
            nativeQuery = true)
    List<Bank> findByWithoutCardsSQL();

}
