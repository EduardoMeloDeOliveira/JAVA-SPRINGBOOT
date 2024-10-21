package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.usuario.DTO.AutenticationRequestDTO;
import med.voll.api.domain.usuario.entity.Usuario;
import med.voll.api.domain.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping()
    public ResponseEntity<Void> register(@RequestBody @Valid AutenticationRequestDTO dto) {

        String encodedPassWord = passwordEncoder.encode(dto.senha());

        Usuario user = new Usuario(null,dto.email(),encodedPassWord);

        usuarioRepository.save(user);

        return ResponseEntity.ok().build();

    }
}
