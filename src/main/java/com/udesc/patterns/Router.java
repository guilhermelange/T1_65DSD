package com.udesc.patterns;

import com.udesc.common.model.Model;
import com.udesc.common.model.Operation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Router {
    private Model model;
    private Operation operation;
    private List<String> params;
    private Map<Model, CrudController> controllers;
    
    public Router(String params) {
        List<String> data = new ArrayList<>(Arrays.asList(params.split(";")));
        validadeRequest(data);
        this.params = data;
        
        this.controllers = new HashMap<>();
        this.controllers.put(Model.PESSOA, new PessoaController());
        this.controllers.put(Model.FAMILIA, new FamiliaController());
    }

    private void validadeRequest(List<String> data) {
        String model = "";
        try {
            model = data.remove(0).trim().toUpperCase();
            this.model = Model.valueOf(model);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("O parâmetro Entidade é obrigatório");
        } catch (Exception e) {
            if (model.isEmpty()) {
                throw new RuntimeException("O parâmetro Entidade é obrigatório");
            } else {
                throw new RuntimeException("Entidade " + model + " é inválida");
            }
        }
        
        String operation = "";
        try {
            operation = data.remove(0).trim().toUpperCase();
            this.operation = Operation.valueOf(operation);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("O parâmetro Operação é obrigatório");
        } catch (Exception e) {
            if (operation.isEmpty()) {
                throw new RuntimeException("O parâmetro Operação é obrigatório");
            } else {
                throw new RuntimeException("Operação " + operation + " é inválida");
            }
        }
    }
    
    public String handleControllerOperation() {
        CrudController controller = controllers.get(model);

        switch (operation) {
            case INSERT:
                return controller.insert(params);
            case UPDATE:
                return controller.update(params);
            case DELETE:
                return controller.delete(params.get(0));
            case GET:
                return controller.get(params.get(0));
            case LIST:
                return controller.list();
            case ADD:
                return controller.add(params);
            case REMOVE:
                return controller.remove(params);
            default:
                throw new RuntimeException("Operação não prevista");
        }
    }
}
