package com.exemplo.Emprestimo;

import com.exemplo.emprestimo.Emprestimo;
import com.exemplo.emprestimo.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @PostMapping("/emprestimo")
    public int salvar(@RequestParam int idUsuario, @RequestParam int idEpi, String dataRetirada, String dataDevolucao, boolean confirmacaoRetirada) {
        emprestimoRepository.salvar(new Emprestimo(idUsuario, idEpi, dataRetirada, dataDevolucao, confirmacaoRetirada));
        return "redirect:/emprestimo";
    }

    @GetMapping("/emprestimo")
    @ResponseBody
    public List<Emprestimo> listar() {
        return emprestimoRepository.buscarTodos();
    }
}