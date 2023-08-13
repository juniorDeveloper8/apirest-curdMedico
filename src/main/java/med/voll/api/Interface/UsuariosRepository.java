package med.voll.api.Interface;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import med.voll.api.model.Usuario.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
  Page<Usuarios> findByActivoTrue(Pageable paginacion);

  UserDetails findByLogin(String username);

}
