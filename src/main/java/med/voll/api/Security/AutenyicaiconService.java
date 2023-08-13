package med.voll.api.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import med.voll.api.Interface.UsuariosRepository;

@Service
public class AutenyicaiconService implements UserDetailsService {

  @Autowired
  private UsuariosRepository usuariosRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    return usuariosRepository.findByLogin(username);
  }

}
