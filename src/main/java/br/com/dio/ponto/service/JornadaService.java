package br.com.dio.ponto.service;

import br.com.dio.ponto.model.JornadaTrabalho;
import br.com.dio.ponto.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaService {

    @Autowired
    JornadaRepository jornadaRepository;

    public List<JornadaTrabalho> listarJornadas(){
        return jornadaRepository.findAll();
    }

    public Optional<JornadaTrabalho> buscarJornadaPorId(Integer idJornada){
        return jornadaRepository.findById(idJornada);
    }

    public JornadaTrabalho salvarJornada(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }

    public JornadaTrabalho atualizarJornada(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }

    public void deletarJornada(Integer idJornada){
        jornadaRepository.deleteById(idJornada);
    }

}
