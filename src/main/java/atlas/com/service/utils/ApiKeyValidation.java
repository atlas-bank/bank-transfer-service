package atlas.com.service.utils;


import atlas.com.service.exceptions.UnauthorizedException;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyValidation {

    private static final String API_KEY = System.getenv("API_KEY");

    public void validateApiKey(String apiKey) throws UnauthorizedException {
        if (API_KEY == null || API_KEY.isBlank()) {
            throw new UnauthorizedException("OS API-KEY is empty");
        }
        if (apiKey == null) {
            throw new UnauthorizedException("Header apikey is null");
        }
        if (!API_KEY.equals(apiKey)) {
            throw new UnauthorizedException("Invalid API-KEY");
        }

    }

}
