package med.voll.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.Data.DatosAutenticacionUsuario;
import med.voll.api.Data.DatosJWTToken;
import med.voll.api.Services.TokenService;
import med.voll.api.model.Usuario.Usuarios;

@RestController
@RequestMapping(value = "/login")
public class AutenticacionContoller {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private TokenService tokenService;

  /*
   * esto es un triger para login
   */
  @PostMapping
  public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
    Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),
        datosAutenticacionUsuario.clave());
    var usuarioAutenticado = authenticationManager.authenticate(authToken);
    var JWTtoken = tokenService.generaToken((Usuarios) usuarioAutenticado.getPrincipal());
    return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
  }
}
