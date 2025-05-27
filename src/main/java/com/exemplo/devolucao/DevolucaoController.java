package com.exemplo.devolucao;

import com.exemplo.devolucao.Devolucao;
import com.exemplo.devolucao.DevolucaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class DevolucaoController {

    @Autowired
    private com.exemplo.emprestimo.EmprestimoRepository EmprestimoRepository;

    @PostMapping("/devolucao")
    public String salvar(@RequestParam int id, int idEmprestimo, String dataDevolucao) {
        DevolucaoRepository.salvar(new Devolucao(id, idEmprestimo, dataDevolucao));
        return "redirect:/devolucao";
    }

    @GetMapping("/devolucao")
    @ResponseBody
    public List<Devolucao> listar() {
        return DevolucaoRepository.buscarTodos();
    }
}
