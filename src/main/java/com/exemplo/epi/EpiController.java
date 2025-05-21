package com.exemplo.epi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class EpiController {

    @Autowired
    private EpiRepository epiRepository;

    @PostMapping("/epis")
    public String salvar(@RequestParam String nome, @RequestParam int quantidade) {
        epiRepository.salvar(new Epi(nome, quantidade));
        return "redirect:/epis";
    }

    @GetMapping("/epis")
    @ResponseBody
    public List<Epi> listar() {
        return epiRepository.buscarTodos();
    }
}
