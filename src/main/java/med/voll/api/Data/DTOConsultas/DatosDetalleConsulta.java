package med.voll.api.Data.DTOConsultas;

import java.time.LocalDateTime;

public record DatosDetalleConsulta(

    Long id,
    Long idPaciente,
    Long idMedico,
    LocalDateTime fecha) {
}
