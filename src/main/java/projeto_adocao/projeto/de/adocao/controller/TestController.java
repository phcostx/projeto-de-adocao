package projeto_adocao.projeto.de.adocao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto_adocao.projeto.de.adocao.repository.AdocaoRepository;
import projeto_adocao.projeto.de.adocao.repository.AvaliacaoRepository;
import projeto_adocao.projeto.de.adocao.repository.PetRepository;
import projeto_adocao.projeto.de.adocao.repository.UsuarioRepository;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @GetMapping("/status")
    public String testStatus() {
        return "Aplicação está funcionando! Repositórios carregados com sucesso.";
    }
} 