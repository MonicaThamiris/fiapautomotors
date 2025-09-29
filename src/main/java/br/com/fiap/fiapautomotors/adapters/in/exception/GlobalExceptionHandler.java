package br.com.fiap.fiapautomotors.adapters.in.exception;

import br.com.fiap.fiapautomotors.adapters.in.controller.response.ErroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exception) {
        String message = String.format("Parâmetro %s com valor inválido.", exception.getName());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(
                        ErroResponse.builder()
                                .codigo(HttpStatus.UNPROCESSABLE_ENTITY.value())
                                .mensagem(message)
                                .build());
    }
}
