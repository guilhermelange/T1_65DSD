package com.udesc.patterns;

import com.udesc.common.model.Familia;
import com.udesc.common.model.Pessoa;
import com.udesc.db.Database;
import java.util.Map;

public class FamiliaService {
    private Database database;
    
    public FamiliaService() {
        this.database = Database.getInstance();
    }
    
    public String insert(Familia familia) {
        Map<String, Familia> familias = database.getFamilias();
        familias.put(familia.getSobrenome(), familia);
        return "Família inserida com sucesso";
    }
    
    public String update(Familia familia) {
        Map<String, Familia> familias = database.getFamilias();
        Familia familiaAtual = familias.get(familia.getSobrenome());
        
        if (familiaAtual == null) {
            return "Família não encontrada";
        }
        
        familias.put(familia.getSobrenome(), familia);
        return "Família atualizada com sucesso";
    }
    
    public String delete(String sobrenome) {
        Map<String, Familia> familias = database.getFamilias();
        
        if (familias.size() <= 0) {
            return "Sem famílias cadastradas";
        }
        
        Familia familia = familias.remove(sobrenome);
        if (familia == null) {
            return "Família não encontrada";
        }
        
        return "Família removida com sucesso";
    }
    
    public String get(String sobrenome) {
        Map<String, Familia> familias = database.getFamilias();
        
        if (familias.size() <= 0) {
            return "Sem famílias cadastradas";
        }
        
        Familia familia = familias.get(sobrenome);
        if (familia == null) {
            return "Família não encontrada";
        }
        
        return familia.toString();
    }
    
    public String list() {
        Map<String, Familia> familias = database.getFamilias();
        
        if (familias.size() <= 0) {
            return "Sem famílias cadastradas";
        }
        
        String result = "";
        for (Map.Entry<String, Familia> entry : familias.entrySet()) {
            Familia familia = entry.getValue();
            result += (result.isEmpty()) ? "" : "\n";
            result += familia.toString();
        }
        return result;
    }
    
    public String add(String sobrenome, String cpf) {
        Map<String, Familia> familias = database.getFamilias();
        Familia familia = familias.get(sobrenome);
        
        if (familia == null) {
            return "Família não localizada";
        }
        
        Pessoa pessoa = database.getPessoas().get(cpf);
        if (pessoa == null) {
            return "Pessoa não localizada para o CPF: " + cpf;
        }
        
        Pessoa pessoaLocalizada = familia.getIntegrantes().get(cpf);
        if (pessoaLocalizada != null) {
            return "Pessoa já está na família";
        }
        
        familia.getIntegrantes().put(cpf, pessoa);
        return "Pessoa adicionada à família";
    }
    
    public String remove(String sobrenome, String cpf) {
        Map<String, Familia> familias = database.getFamilias();
        Familia familia = familias.get(sobrenome);
        
        if (familia == null) {
            return "Família não localizada";
        }
        
        Pessoa pessoa = familia.getIntegrantes().get(cpf);
        if (pessoa == null) {
            return "Pessoa não localizada na família";
        }
        
        familia.getIntegrantes().remove(cpf);
        return "Pessoa removida da família";
    }
}
