package atlas.com.service.controllers;

import atlas.com.service.dtos.CreateCardDTO;
import atlas.com.service.services.CardService;
import atlas.com.service.utils.ApiKeyValidation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService service;
    private final ApiKeyValidation apiKeyValidation;

    public CardController(CardService service, ApiKeyValidation apiKeyValidation) {
        this.service = service;
        this.apiKeyValidation = apiKeyValidation;
    }

    @PostMapping
    public String createCard(@RequestBody CreateCardDTO dto, @RequestHeader("x-api-key") String apiKey) {
        apiKeyValidation.validateApiKey(apiKey);

        service.createCard(dto.userId(), dto.pin());

        return "Not Implemented";
    }
}
