package br.com.zupacademy.rafael.casadocodigo.configuration;

import static br.com.zupacademy.rafael.casadocodigo.configuration.utils.StringHandler.*;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestControllerAdvice
public class ValidationErrorHandler {

    private MessageSource messageSource;

    public ValidationErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationErrorsOutputDto> handle(MethodArgumentNotValidException exception) {
        List<ValidationErrorsOutputDto> dto = new ArrayList<ValidationErrorsOutputDto>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ValidationErrorsOutputDto erro = new ValidationErrorsOutputDto(e.getField(), mensagem);
            dto.add(erro);
        });
        return dto;
    }
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ValidationErrorsOutputDto handleInternal(DataIntegrityViolationException exception) {
        Optional<String> mensagemException = Optional.of(getStringBetweenChars(exception.getMostSpecificCause().toString(),"entry '","' for"));
        if(mensagemException.isPresent() && mensagemException.get().contains("@")){
            String mensagem = "Email "+mensagemException.get()+" já cadastrado!";
            ValidationErrorsOutputDto erro = new ValidationErrorsOutputDto("email", mensagem);
            return erro;
        }
        ValidationErrorsOutputDto erro2 = new ValidationErrorsOutputDto("Violação de constraint",exception.getMostSpecificCause().toString());
        return erro2;
    }
}
