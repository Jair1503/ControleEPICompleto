package com.exemplo.usuario;


import com.exemplo.usuario.Usuario;
import com.exemplo.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @PostMapping("/usuario")
    public String salvar(@RequestParam String nome, @RequestParam String email, String senha, String perfil) {
        UsuarioRepository.salvar(new Usuario(nome, email, senha, perfil));
        return "redirect:/usuario";
    }

    @GetMapping("/usuario")
    @ResponseBody
    public List<Usuario> listar() {
        return UsuarioRepository.buscarTodos();
    }
}
