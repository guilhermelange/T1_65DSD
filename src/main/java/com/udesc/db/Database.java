package com.udesc.db;

import com.udesc.common.model.Familia;
import com.udesc.common.model.Pessoa;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Database instance;
    private Map<String, Pessoa> pessoas;
    private Map<String, Familia> familias;
    
    private Database() {
        pessoas = new HashMap<>();
        familias = new HashMap<>();
    }
    
    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Map<String, Familia> getFamilias() {
        return familias;
    }

    public Map<String, Pessoa> getPessoas() {
        return pessoas;
    }
}
