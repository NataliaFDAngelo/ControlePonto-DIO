package br.com.dio.ponto.controller;

import br.com.dio.ponto.model.JornadaTrabalho;
import br.com.dio.ponto.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @GetMapping
    public List<JornadaTrabalho> getJornada(){
        return jornadaService.listarJornadas();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("idJornada") Integer idJornada) throws Exception {
        return ResponseEntity.ok(jornadaService.buscarJornadaPorId(idJornada)
                .orElseThrow(() -> new Exception("Jornada não encontrada.")));
    }

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.salvarJornada(jornadaTrabalho);
    }

    @PutMapping("/{idJornada}")
    public ResponseEntity updateByID(@PathVariable("idJornada") Integer idJornada,
                                     @RequestBody JornadaTrabalho jornadaTrabalho) throws Exception {
        JornadaTrabalho jornada = jornadaService.buscarJornadaPorId(idJornada)
                .orElseThrow(() -> new NoSuchElementException("Dado não encontrado"));
        jornada.setDescricao(jornadaTrabalho.getDescricao());

        JornadaTrabalho jornadaAlterada = jornadaService.atualizarJornada(jornada);

        return ResponseEntity.ok(jornadaAlterada);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteByID(@PathVariable("idJornada") Integer idJornada) throws Exception {
        try {
            jornadaService.deletarJornada(idJornada);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }




}
