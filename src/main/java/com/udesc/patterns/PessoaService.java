package com.udesc.patterns;

import com.udesc.common.model.Pessoa;
import com.udesc.db.Database;
import java.util.Map;

public class PessoaService {
    private Database database;
    
    public PessoaService() {
        this.database = Database.getInstance();
    }
    
    public String insert(Pessoa pessoa) {
        Map<String, Pessoa> pessoas = database.getPessoas();
        pessoas.put(pessoa.getCpf(), pessoa);
        return "Pessoa inserida com sucesso";
    }
    
    public String update(Pessoa pessoa) {
        Map<String, Pessoa> pessoas = database.getPessoas();
        Pessoa pessoaAtual = pessoas.get(pessoa.getCpf());
        
        if (pessoaAtual == null) {
            return "Pessoa não encontrada";
        }
        
        pessoas.put(pessoa.getCpf(), pessoa);
        return "Pessoa atualizada com sucesso";
    }
    
    public String delete(String cpf) {
        Map<String, Pessoa> pessoas = database.getPessoas();
        
        if (pessoas.size() <= 0) {
            return "Sem pessoas cadastradas";
        }
        
        Pessoa pessoa = pessoas.remove(cpf);
        if (pessoa == null) {
            return "Pessoa não encontrada";
        }
        
        return "Pessoa removida com sucesso";
    }
    
    public String get(String cpf) {
        Map<String, Pessoa> pessoas = database.getPessoas();
        
        if (pessoas.size() <= 0) {
            return "Sem pessoas cadastradas";
        }
        
        Pessoa pessoa = pessoas.get(cpf);
        if (pessoa == null) {
            return "Pessoa não encontrada";
        }
        
        return pessoa.toString();
    }
    
    public String list() {
        Map<String, Pessoa> pessoas = database.getPessoas();
        
        if (pessoas.size() <= 0) {
            return "Sem pessoas cadastradas";
        }
        
        String result = String.valueOf(pessoas.size());
        for (Map.Entry<String, Pessoa> entry : pessoas.entrySet()) {
            result += "\n" + entry.getValue().toString();
        }
        return result;
    }
}
