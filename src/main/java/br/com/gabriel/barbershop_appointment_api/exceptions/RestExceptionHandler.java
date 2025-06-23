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

    @ExceptionHandler(InvalidDateTimeException.class)
    private ResponseEntity<String> invalidDateTimeHandler(InvalidDateTimeException error) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        String responseJson = String.format("{\"timestamp\": \"%s\", \"message\": \"%s\"}",
            currentDateTime,
            error.getMessage());

        return new ResponseEntity<String>(responseJson, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppointmentTimeAlreadyExists.class)
    private ResponseEntity<String> appointmentTimeAlreadyExistsHandler(AppointmentTimeAlreadyExists error) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        String responseJson = String.format("{\"timestamp\": \"%s\", \"message\": \"%s\"}",
            currentDateTime,
            error.getMessage());

        return new ResponseEntity<String>(responseJson, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TimeNotFoundException.class)
    private ResponseEntity<String> timeNotfoundHandler(TimeNotFoundException error) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        String responseJson = String.format("{\"timestamp\": \"%s\", \"message\": \"%s\"}",
            currentDateTime,
            error.getMessage());

        return new ResponseEntity<String>(responseJson, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TimeAlreadyExistsException.class)
    private ResponseEntity<String> timeAlreadyExistsHandler(TimeAlreadyExistsException error) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        String responseJson = String.format("{\"timestamp\": \"%s\", \"message\": \"%s\"}",
            currentDateTime,
            error.getMessage());

        return new ResponseEntity<String>(responseJson, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidTimeFormatException.class)
    private ResponseEntity<String> invalidTimeFormatHandler(InvalidTimeFormatException error) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        String responseJson = String.format("{\"timestamp\": \"%s\", \"message\": \"%s\"}",
            currentDateTime,
            error.getMessage());

        return new ResponseEntity<String>(responseJson, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsInAppointmentTimeListException.class)
    private ResponseEntity<String> userAlreadyExistsInAppointmentTimeListHandler(UserAlreadyExistsInAppointmentTimeListException error) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        String responseJson = String.format("{\"timestamp\": \"%s\", \"message\": \"%s\"}",
            currentDateTime,
            error.getMessage());

        return new ResponseEntity<String>(responseJson, HttpStatus.BAD_REQUEST);
    } 

    @ExceptionHandler(CustomerAlreadyHasAppointmentException.class)
    private ResponseEntity<String> youUserAlreadyExistsInAppointmentTimeListHandler(CustomerAlreadyHasAppointmentException error) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        String responseJson = String.format("{\"timestamp\": \"%s\", \"message\": \"%s\"}",
            currentDateTime,
            error.getMessage());

        return new ResponseEntity<String>(responseJson, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerHairCutNotFoundException.class)
    private ResponseEntity<String> customerHaircutNotFoundHandler(CustomerHairCutNotFoundException error) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        String responseJson = String.format("{\"timestamp\": \"%s\", \"message\": \"%s\"}",
            currentDateTime,
            error.getMessage());

        return new ResponseEntity<String>(responseJson, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AvailableTimeNotFoundException.class)
    private ResponseEntity<String> availableTimeNotFoundExceptionHandler(AvailableTimeNotFoundException error) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        String responseJson = String.format("{\"timestamp\": \"%s\", \"message\": \"%s\"}",
            currentDateTime,
            error.getMessage());

        return new ResponseEntity<String>(responseJson, HttpStatus.NOT_FOUND);
    }
}
