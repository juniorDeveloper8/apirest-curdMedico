package med.voll.api.validations;

import med.voll.api.Data.DTOConsultas.DatosAgendarConsulta;

public interface ValidadorDeConsultas {
  public void validar(DatosAgendarConsulta datos);
}