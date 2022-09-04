package com.udesc.patterns;

import com.udesc.common.model.Pessoa;
import java.util.List;

public class PessoaController implements CrudController {
    private PessoaService pessoaService;
    
    public PessoaController() {
        this.pessoaService = new PessoaService();
    }
    
    public String insert(List<String> params) {
        Pessoa pessoa = new Pessoa(params.get(0), params.get(1), params.get(2));
        return this.pessoaService.insert(pessoa);
    }
    
    public String update(List<String> params) {
        Pessoa pessoa = new Pessoa(params.get(0), params.get(1), params.get(2));
        return this.pessoaService.update(pessoa);
    }
    
    public String delete(String cpf) {
        return this.pessoaService.delete(cpf);
    }
    
    public String get(String cpf) {
        return this.pessoaService.get(cpf);
    }
    
    public String list() {
        return this.pessoaService.list();
    }

    public String add(List<String> params) {
        throw new UnsupportedOperationException("Método não suportado para pessoas.");
    }

    public String remove(List<String> params) {
        throw new UnsupportedOperationException("Método não suportado para pessoas.");
    }
}
