package med.voll.api.Controllers.ClienteController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.Data.DTOConsultas.DatosAgendarConsulta;
import med.voll.api.Data.DTOConsultas.DatosDetalleConsulta;

@RestController
@ResponseBody
@RequestMapping(value = "/consultas")
public class ConsultaController {

  @PostMapping
  @Transactional
  public ResponseEntity agregar(@RequestBody @Valid DatosAgendarConsulta datos) {

    System.out.println(datos);

    return ResponseEntity.ok(new DatosDetalleConsulta(null, null, null, null));

  }
}
