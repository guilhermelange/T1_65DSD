package com.udesc.patterns;

import com.udesc.common.model.Familia;
import java.util.List;

public class FamiliaController implements CrudController {
    private FamiliaService familiaService;
    
    public FamiliaController() {
        this.familiaService = new FamiliaService();
    }
    
    public String insert(List<String> params) {
        Familia familia = new Familia(params.get(0), params.get(1), Double.valueOf(params.get(2)));
        return this.familiaService.insert(familia);
    }
    
    public String update(List<String> params) {
        Familia familia = new Familia(params.get(0), params.get(1), Double.valueOf(params.get(2)));
        return this.familiaService.update(familia);
    }
    
    public String delete(String sobrenome) {
        return this.familiaService.delete(sobrenome);
    }
    
    public String get(String sobrenome) {
        return this.familiaService.get(sobrenome);
    }
    
    public String list() {
        return this.familiaService.list();
    }

    public String add(List<String> params) {
        String sobrenome = params.get(0);
        String cpf = params.get(1);
        return this.familiaService.add(sobrenome, cpf);
    }

    public String remove(List<String> params) {
        String sobrenome = params.get(0);
        String cpf = params.get(1);
        return this.familiaService.remove(sobrenome, cpf);
    }
}
