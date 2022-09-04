package com.udesc.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Router {
    private String model;
    private String operation;
    private List<String> params;
    private Map<String, CrudController> controllers;
    
    public Router(String params) {
        List<String> data = new ArrayList<String>(Arrays.asList(params.split(";")));
        this.model = data.remove(0);
        this.operation = data.remove(0);
        this.params = data;
        
        this.controllers = new HashMap<String, CrudController>();
        this. controllers.put("PESSOA", new PessoaController());
    }
    
    public CrudController getController(String model) {
        return controllers.get(model);
    }
    
    public String handleControllerOperation() {
        CrudController controller = controllers.get(model.toUpperCase());
        
        switch (operation.toUpperCase()) {
            case "INSERT":
                return controller.insert(params);
            case "UPDATE":
                return controller.update(params);
            case "DELETE":
                return controller.delete(params.get(0));
            case "GET":
                return controller.get(params.get(0));
            case "LIST":
                return controller.list();
            default:
                throw new Error("Operação não prevista");
        }
    }
}
