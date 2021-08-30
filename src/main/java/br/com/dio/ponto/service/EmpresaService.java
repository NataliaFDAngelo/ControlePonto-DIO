package br.com.dio.ponto.service;

import br.com.dio.ponto.model.Empresa;
import br.com.dio.ponto.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> buscarEmpresaPorId(Integer idEmpresa) {
        return empresaRepository.findById(idEmpresa);
    }

    public Empresa salvarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa alterarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void excluirEmpresa(Integer idEmpresa){
        empresaRepository.deleteById(idEmpresa);
    }

}
