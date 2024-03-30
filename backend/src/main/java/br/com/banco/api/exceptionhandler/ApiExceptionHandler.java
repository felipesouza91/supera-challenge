package br.com.banco.api.exceptionhandler;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.banco.domain.exception.ContaNaoEncontrada;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
  public static final String MSG_ERRO_GENERICA_USUARIO = "Ocorreu um erro no sistema tente novamente mais tarde";

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    return ResponseEntity.status(status).headers(headers).build();
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleUncaught(Exception ex, WebRequest request) {
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    String detail = MSG_ERRO_GENERICA_USUARIO;

    log.error(ex.getMessage(), ex);

    Problem problem = createProblemBuilder(status, detail)
        .userMessage(detail)
        .build();

    return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
  }

  @ExceptionHandler(ContaNaoEncontrada.class)
  public ResponseEntity<?> handleEntidadeNaoEncontrada(ContaNaoEncontrada ex,
      WebRequest request) {

    HttpStatus status = HttpStatus.NOT_FOUND;
    String detail = ex.getMessage();

    Problem problem = createProblemBuilder(status, detail)
        .userMessage(detail)
        .build();

    return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
  }

  private Problem.ProblemBuilder createProblemBuilder(HttpStatus status,
      String detail) {

    return Problem.builder()
        .timestamp(OffsetDateTime.now())
        .status(status.value())
        .detail(detail);
  }
}
