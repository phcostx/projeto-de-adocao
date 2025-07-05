package projeto_adocao.projeto.de.adocao.service;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import projeto_adocao.projeto.de.adocao.model.Usuario;
import projeto_adocao.projeto.de.adocao.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(null);
    }

    public void deletarUsuarioPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        usuarioRepository.delete(usuario);
    }
}
