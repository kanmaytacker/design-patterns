package com.scaler.lld.design.creational.prototype.mlmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MLModel implements ObjectClonable {

    private ModelType type;
    private String description;
    private double trainingSplit;
    private double validationSplit;
    private double alpha;
    private double beta;

    // Step 2: Implement clone method
    public MLModel clone() {
        return new MLModel(type, description, trainingSplit, validationSplit, alpha, beta);
    }

}
