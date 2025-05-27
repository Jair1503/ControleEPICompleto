package com.exemplo.emprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class EmprestimoController {

    @Autowired
    private com.exemplo.emprestimo.EmprestimoRepository emprestimoRepository;

    @PostMapping("/emprestimo")
    public String salvar(@RequestParam int id, int idUsuario, int idEpi, @RequestParam String dataRetirada, String dataPrevistaDevolucao, boolean confirmacaoRetirada) {
        EmprestimoRepository.salvar(new Emprestimo(id, idUsuario, idEpi, dataRetirada,dataPrevistaDevolucao, confirmacaoRetirada));
        return "redirect:/emprestimo";
    }

    @GetMapping("/emprestimo")
    @ResponseBody
    public List<Emprestimo> listar() {
        return EmprestimoRepository.buscarTodos();
    }
}
