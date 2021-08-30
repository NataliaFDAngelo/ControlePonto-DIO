package br.com.dio.ponto.controller;

import br.com.dio.ponto.model.Empresa;
import br.com.dio.ponto.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping
    public List<Empresa> getEmpresas(){
        return empresaService.listarEmpresas();
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable("idEmpresa") Integer idEmpresa) throws Exception{
        return ResponseEntity.ok(empresaService.buscarEmpresaPorId(idEmpresa)
                .orElseThrow(() -> new Exception("Empresa não encontrada.")));
    }

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa){
        return empresaService.salvarEmpresa(empresa);
    }

    @PutMapping("/{idEmpresa}")
    public ResponseEntity updateById(@PathVariable("idEmpresa") Integer idEmpresa,
                                     @RequestBody Empresa empresa) throws Exception{
        Empresa empresaLocalizada = empresaService.buscarEmpresaPorId(idEmpresa)
                .orElseThrow(() -> new Exception("Empresa não encontrada."));
        empresaLocalizada.setDescricao(empresa.getDescricao());
        empresaLocalizada.setCnpj(empresa.getCnpj());
        empresaLocalizada.setEndereco(empresa.getEndereco());
        empresaLocalizada.setBairro(empresa.getBairro());
        empresaLocalizada.setCidade(empresa.getCidade());
        empresaLocalizada.setEstado(empresa.getEstado());
        empresaLocalizada.setTelefone(empresa.getTelefone());

        Empresa empresaAlterada = empresaService.alterarEmpresa(empresaLocalizada);

        return ResponseEntity.ok(empresaAlterada);
    }

    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity deleteById(@PathVariable("idEmpresa") Integer idEmpresa) throws Exception{
        try {
            empresaService.excluirEmpresa(idEmpresa);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }

}
