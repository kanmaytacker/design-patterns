package com.scaler.lld.design.creational.prototype.mlmodel;

import java.util.HashMap;
import java.util.Map;

// Step 3 - Create and populate registry 
public class ModelRegistry {
    
    private Map<ModelType, MLModel> models = new HashMap<>();

    public void registerModel(MLModel model) {
        models.put(model.getType(), model);
    }

    public MLModel getModel(ModelType type) {
        return models.get(type);
    }

}
