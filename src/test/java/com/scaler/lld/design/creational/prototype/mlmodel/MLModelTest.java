package com.scaler.lld.design.creational.prototype.mlmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MLModelTest {

    private ModelRegistry registry = null;

    @Before
    public void setUp() {

        registry = new ModelRegistry();

        registry.registerModel(new MLModel(ModelType.LR, "Linear Regression", 0.8, 0.2, 0.1, 0.9));
        registry.registerModel(new MLModel(ModelType.SVM, "Support Vector Machine", 0.8, 0.2, 0.1, 0.9));
        registry.registerModel(new MLModel(ModelType.DT, "Decision Tree", 0.8, 0.2, 0.1, 0.9));
    }

    // teardown

    @Test
    public void testModelCreation() {
        MLModel model = new MLModel(ModelType.LR, "description1", 0.7, 0.3, 0.1, 0.2);
        assertEquals("If name is set, it should be equal to LR", "LR", model.getType().name());
    }

    @Test
    public void testModelCloning() {

        MLModel model = new MLModel(ModelType.LR, "description1", 0.7, 0.3, 0.1, 0.2);
        MLModel clonedModel = model.clone();

        assertEquals("If name is set, it should be equal to LR", ModelType.LR, clonedModel.getType());
        assertFalse("If clone is called, a new copy should be returned", model == clonedModel);
    }

    @Test
    public void testRegistry() {
        MLModel model = registry.getModel(ModelType.LR);
        assertNotNull("If model is populated, it should not be null", model);
    }

    // Step 3 - Clone models using prototype
    @Test
    private void testMultipleCopies() {

        MLModel prototype = new MLModel(ModelType.LR, "description1", 0.7, 0.3, 0.1, 0.2);
        List<MLModel> models = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            MLModel clonedModel = prototype.clone();
            clonedModel.setAlpha(prototype.getAlpha() * i);
            clonedModel.setBeta(i / prototype.getBeta());
            models.add(clonedModel);
        }

    }

    @Test
    public void createUsingRegistry() {

        // Create first prototype
        MLModel prototype1 = new MLModel(ModelType.LR, "description1", 0.7, 0.3, 0.1, 0.2);

        // Populate registry
        ModelRegistry registry = new ModelRegistry();
        registry.registerModel(prototype1);

        MLModel prototype2 = new MLModel(ModelType.SVM, "description2", 0.7, 0.3, 0.1, 0.2);
        registry.registerModel(prototype2);

        List<MLModel> models = new ArrayList<>();

        // Create multiple models of type 1
        for (int i = 0; i < 10; i++) {
            MLModel clonedModel = prototype1.clone();
            clonedModel.setAlpha(prototype1.getAlpha() * i);
            clonedModel.setBeta(i / prototype1.getBeta());
            models.add(clonedModel);
        }

        // Create multiple models of type 2
        for (int i = 0; i < 10; i++) {
            MLModel clonedModel = prototype2.clone();
            clonedModel.setAlpha(prototype2.getAlpha() * i);
            clonedModel.setBeta(i / prototype2.getBeta());
            models.add(clonedModel);
        }
    }

}
