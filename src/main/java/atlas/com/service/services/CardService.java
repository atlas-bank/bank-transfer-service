package atlas.com.service.services;

import atlas.com.service.dtos.CardTokenizationDTO;
import atlas.com.service.dtos.CreateCardDTO;
import atlas.com.service.models.Card;
import atlas.com.service.repositories.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CardRepository repository;
    private final TokenizationService tokenizationService;

    public CardService(CardRepository repository, TokenizationService tokenizationService) {
        this.repository = repository;
        this.tokenizationService = tokenizationService;
    }

    public String validateAndCreateCard(CreateCardDTO dto) {
        this.createCard(dto);
        return "Card Created";
    }

    private void createCard(CreateCardDTO dto) {
        String tokenizedCardID = tokenizationService.tokenizeCard(
                new CardTokenizationDTO(
                        dto.pin(),
                        dto.userCPF()
                )
        );
        Card card = new Card(
                tokenizedCardID,
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
