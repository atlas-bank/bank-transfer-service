package atlas.com.service.exceptions;

import atlas.com.service.responses.ApiResponse;
import atlas.com.service.responses.ApiResponseRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final ApiResponse response = new ApiResponse();

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiResponseRecord> unauthorizedException(UnauthorizedException ex) {
        return response.of(null, ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseRecord> exception(Exception ex) {
        return response.of(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
