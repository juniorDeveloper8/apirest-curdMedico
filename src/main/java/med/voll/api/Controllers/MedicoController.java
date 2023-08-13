package med.voll.api.Controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.Data.DatosActualizarMedico;
import med.voll.api.Data.DatosDireccion;
import med.voll.api.Data.DatosListadoMedico;
import med.voll.api.Data.DatosRegistroMedico;
import med.voll.api.Data.DatosRepuestaMedico;
import med.voll.api.Interface.MedicoRepository;
import med.voll.api.model.Medico;

/*
 * estos son edpoin en este caso /medico
 */
@RestController
@RequestMapping(value = "/medico")
public class MedicoController {

  @Autowired
  private MedicoRepository medicoRepository;

  /*
   * encapsulamos para no exponer nuetro modelo
   */
  @PostMapping
  public ResponseEntity<DatosRepuestaMedico> registrarMedico(
      @RequestBody @Valid DatosRegistroMedico datosRegistroMedico, UriComponentsBuilder uriComponentsBuilder) {
    Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
    // este tiene q retornar 201 que significa creado
    DatosRepuestaMedico datosRepuestaMedico = new DatosRepuestaMedico(medico.getId(), medico.getNombre(),
        medico.getEmail(),
        medico.getTelefono(), medico.getEspecialidad().toString(),
        new DatosDireccion(medico.getDireccion().getCalle(), medico.getDireccion().getDistrito(),
            medico.getDireccion().getCiudad(), medico.getDireccion().getNumero(),
            medico.getDireccion().getComplemento()));

    URI url = uriComponentsBuilder.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();
    return ResponseEntity.created(url).body(datosRepuestaMedico);
  }

  /**
   * tamos tralledon datos para paginas
   * 
   * @param paginacion
   * @return
   */

  @GetMapping
  public ResponseEntity<Page<DatosListadoMedico>> listadoMedicos(@PageableDefault(size = 5) Pageable paginacion) {
    // return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
    // referencia de listar sin validaciones logicas
    return ResponseEntity.ok(medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new));
  }

  /**
   * actualizacion de datos atraves de trabasacitional para evitar la
   * incosistencia de datos
   * es una logica culera
   * 
   * @param datosActualizarMedico
   */
  @PutMapping
  @Transactional
  public ResponseEntity<DatosRepuestaMedico> actualizarMedico(
      @RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
    Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
    medico.actualizarDatos(datosActualizarMedico);
    return ResponseEntity.ok(new DatosRepuestaMedico(medico.getId(), medico.getNombre(), medico.getEmail(),
        medico.getTelefono(), medico.getEspecialidad().toString(),
        new DatosDireccion(medico.getDireccion().getCalle(), medico.getDireccion().getDistrito(),
            medico.getDireccion().getCiudad(), medico.getDireccion().getNumero(),
            medico.getDireccion().getComplemento())));

  }

  /*
   * forma de borrar un registro de manera logica
   * El responseEntiy es para personalisar las respuestas de nuestro codigo
   */

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<DatosRepuestaMedico> eleminarMedico(@PathVariable Long id) {
    Medico medico = medicoRepository.getReferenceById(id);
    medico.desactivarMedico();
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}")
  @Transactional
  public ResponseEntity<DatosRepuestaMedico> retornaDatosMedico(@PathVariable Long id) {
    Medico medico = medicoRepository.getReferenceById(id);
    medico.desactivarMedico();
    var datosMedico = new DatosRepuestaMedico(medico.getId(), medico.getNombre(), medico.getEmail(),
        medico.getTelefono(), medico.getEspecialidad().toString(),
        new DatosDireccion(medico.getDireccion().getCalle(), medico.getDireccion().getDistrito(),
            medico.getDireccion().getCiudad(), medico.getDireccion().getNumero(),
            medico.getDireccion().getComplemento()));
    return ResponseEntity.ok(datosMedico);
  }

  /**
   * forma de borrar un registro de la Bace de datos
   * 
   * @param id
   */
  /*
   * @DeleteMapping("/{id}")
   * 
   * @Transactional
   * public void eleminarMedico(@PathVariable Long id) {
   * Medico medico = medicoRepository.getReferenceById(id);
   * medicoRepository.delete(medico);
   * }
   */
  // metodo que nos permite eliminar el registro por medio del ID

}