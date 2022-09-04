package com.udesc.patterns;

import java.util.List;

public interface CrudController {
    public String insert(List<String> params);
    
    public String update(List<String> params);
    
    public String delete(String cpf);
    
    public String get(String cpf);
    
    public String list();
    
    public String add(List<String> params);
    
    public String remove(List<String> params);
}
