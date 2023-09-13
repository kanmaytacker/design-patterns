package com.scaler.lld.design.structural.decorator.database;

import lombok.AllArgsConstructor;

// Step 3 - Base decorator
@AllArgsConstructor
public abstract class BaseDecorator implements Datasource {
    protected Datasource nextLayer;
}
