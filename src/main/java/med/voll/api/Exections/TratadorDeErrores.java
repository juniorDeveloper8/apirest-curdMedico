package med.voll.api.Exections;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

/*
 * personalizaiconde exepciones en este caso solo esta la de traer datso y ingresar datos
 */
@RestControllerAdvice
public class TratadorDeErrores {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity TratarError404() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity TratarError400(MethodArgumentNotValidException e) {

    var errores = e.getFieldErrors().stream().map(DatosErrorValidation::new).toList();
    return ResponseEntity.badRequest().body(errores);
  }

  /*
   * generando un pequeno dto personalizado para poder responder lo nesesario al
   * guardar datos de manera que sea funcional o entendible por el usuario
   */
  private record DatosErrorValidation(String campo, String error) {
    public DatosErrorValidation(FieldError error) {
      this(error.getField(), error.getDefaultMessage());
    }
  }
}
