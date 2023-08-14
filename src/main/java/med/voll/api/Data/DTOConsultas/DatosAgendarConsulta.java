package med.voll.api.Data.DTOConsultas;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record DatosAgendarConsulta(

    Long id,
    @NotNull Long idPaciente,
    Long idMedico,
    @NotNull @Future LocalDateTime fecha) {
}
