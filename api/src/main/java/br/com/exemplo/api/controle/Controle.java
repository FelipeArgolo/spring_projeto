package br.com.exemplo.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.api.modelo.Pessoa;
import br.com.exemplo.api.repositorio.Repositorio;

@RestController

public class Controle {
    @GetMapping("")
    public String mensagem() {

        return "Ola, Mundo!";
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {

        return "Seja Bem Vindo(a)";
    }

    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome) {

        return "Seja Bem Vindo(a)" + nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p) {
        // TODO: process POST request

        return p;
    }

    @Autowired
    private Repositorio acao;

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }
    
        @GetMapping("/api")
        public List<Pessoa> selecionar(){
           return acao.findAll(); 
        
    }

    @GetMapping ("/api{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable int codigo){
        return acao.findByCodigo(codigo);
    }
    @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }
}
