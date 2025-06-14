package br.com.gabriel.barbershop_appointment_api.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    private ResponseEntity<String> userNotFoundHandler(UserAlreadyExistsException error) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        String responseJson = String.format("{\"timestamp\": \"%s\", \"message\": \"%s\"}",
            currentDateTime,
            error.getMessage());

        return new ResponseEntity<String>(responseJson, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<String> userNotFoundHandler(UserNotFoundException error) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        String responseJson = String.format("{\"timestamp\": \"%s\", \"message\": \"%s\"}",
            currentDateTime,
            error.getMessage());

        return new ResponseEntity<String>(responseJson, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HairCutNotFoundException.class)
    private ResponseEntity<String> hairCutNotFoundHandler(HairCutNotFoundException error) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        String responseJson = String.format("{\"timestamp\": \"%s\", \"message\": \"%s\"}",
            currentDateTime,
            error.getMessage());

            return new ResponseEntity<String>(responseJson, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HairCutAlreadyExistsException.class)
    private ResponseEntity<String> hairCutAlreadyExistsHandler(HairCutAlreadyExistsException error) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        String responseJson = String.format("{\"timestamp\": \"%s\", \"message\": \"%s\"}",
            currentDateTime,
            error.getMessage());

            return new ResponseEntity<String>(responseJson, HttpStatus.NOT_FOUND);
    }
}
