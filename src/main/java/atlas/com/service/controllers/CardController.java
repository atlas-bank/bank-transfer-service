package atlas.com.service.controllers;

import atlas.com.service.dtos.CreateCardDTO;
import atlas.com.service.exceptions.BadRequestException;
import atlas.com.service.responses.ApiResponse;
import atlas.com.service.responses.ApiResponseRecord;
import atlas.com.service.services.CardService;
import atlas.com.service.utils.ApiKeyValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService service;
    private final ApiKeyValidation apiKeyValidation;

    private final ApiResponse response = new ApiResponse();

    public CardController(CardService service, ApiKeyValidation apiKeyValidation) {
        this.service = service;
        this.apiKeyValidation = apiKeyValidation;
    }

    @PostMapping
    public ResponseEntity<ApiResponseRecord> createCard(@RequestBody CreateCardDTO dto) {
        if (dto == null) {
            throw new BadRequestException("Request body is null");
        }

        String message = service.validateAndCreateCard(dto);

        return response.of(null, message, HttpStatus.NOT_IMPLEMENTED);
    }
}
