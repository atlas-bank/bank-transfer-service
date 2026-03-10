package atlas.com.service.services;

import atlas.com.service.dtos.CardTokenizationDTO;
import org.springframework.stereotype.Service;

@Service
public class TokenizationService {
    public String tokenizeCard(CardTokenizationDTO card) {
        //será criado outra api que armazenará os dados de PAN
        //essa função irá chamar fazer uma requisição para essa API interna

        //o retorno será o id desse cartão tokenizado
        return null;
    }
}
