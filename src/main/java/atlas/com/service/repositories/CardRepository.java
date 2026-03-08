package atlas.com.service.repositories;

import atlas.com.service.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CardRepository extends JpaRepository<Card, Long> {

    Card getCardById(Long id);
}
