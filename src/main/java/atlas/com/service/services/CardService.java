package atlas.com.service.services;

import atlas.com.service.dtos.CreateCardDTO;
import atlas.com.service.models.Card;
import atlas.com.service.repositories.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CardRepository repository;

    public CardService(CardRepository repository) {
        this.repository = repository;
    }

    public String validateAndCreateCard(CreateCardDTO dto) {
        this.createCard(dto);
        return "Card Created";
    }

    private void createCard(CreateCardDTO dto) {
        Card card = new Card(
                dto.pin(),
                dto.userCPF(),
                dto.brand(),
                dto.userFullName(),
                dto.deviceId(),
                dto.status(),
                dto.level(),
                dto.international()
        );
        System.out.println(card);
        //repository.save(card);
    }
}
