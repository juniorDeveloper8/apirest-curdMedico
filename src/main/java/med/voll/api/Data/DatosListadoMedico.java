package med.voll.api.Data;

import med.voll.api.model.Medico;

public record DatosListadoMedico(
    Long id,
    String nombre,
    String email,
    String especialidad,
    String documento

) {

  public DatosListadoMedico(Medico medico) {
    this(medico.getId(), medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
  }
}
