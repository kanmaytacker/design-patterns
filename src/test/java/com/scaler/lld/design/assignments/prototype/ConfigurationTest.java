package com.scaler.lld.design.assignments.prototype;

import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigurationTest {

    @Test
    public void testConfigurationImplementsClonableObject() {
        Class<?> configurationClass = Configuration.class;
        Class<?>[] interfaces = configurationClass.getInterfaces();

        boolean implementsClonableObject = false;

        for (Class<?> iface : interfaces) {
            if (iface == ClonableObject.class) {
                implementsClonableObject = true;
                break;
            }
        }

        assertTrue(implementsClonableObject, "If the prototype pattern is implemented correctly, the Configuration class should implement the ClonableObject interface");
    }

    @Test
    public void testConfigurationCloneMethodCreatesDistinctObject() {
        Configuration configuration = new Configuration("Black", true, "English", true, 12, "Arial", ConfigurationType.BASIC);

        // Using reflection to find and invoke the clone method
        try {
            Method cloneMethod = configuration.getClass().getMethod("cloneObject");
            assertNotNull(cloneMethod, "If the prototype pattern is implemented correctly, the Configuration class should have a cloneObject method");

            // Calling the clone method to create a copy
            Configuration clonedConfiguration = (Configuration) cloneMethod.invoke(configuration);
            assertNotNull(clonedConfiguration, "If the clone method is implemented correctly, it should return a non-null object");

            // Validating that the clonedConfiguration is not the same object as configuration
            assertNotSame(configuration, clonedConfiguration, "If the clone method is implemented correctly, it should return a new object");

            // Asserting that the cloned configuration has the same values as the original configuration
            assertEquals(configuration.getThemeColor(), clonedConfiguration.getThemeColor(), "If the clone method is implemented correctly, it should return a new object with the same values as the original object");
            assertEquals(configuration.getAutoSave(), clonedConfiguration.getAutoSave(), "If the clone method is implemented correctly, it should return a new object with the same values as the original object");
            assertEquals(configuration.getFontSize(), clonedConfiguration.getFontSize(), "If the clone method is implemented correctly, it should return a new object with the same values as the original object");
            assertEquals(configuration.getDarkMode(), clonedConfiguration.getDarkMode(), "If the clone method is implemented correctly, it should return a new object with the same values as the original object");
            assertEquals(configuration.getLanguage(), clonedConfiguration.getLanguage(), "If the clone method is implemented correctly, it should return a new object with the same values as the original object");
            assertEquals(configuration.getFontFamily(), clonedConfiguration.getFontFamily(), "If the clone method is implemented correctly, it should return a new object with the same values as the original object");
            assertEquals(configuration.getType(), clonedConfiguration.getType(), "If the clone method is implemented correctly, it should return a new object with the same values as the original object");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("If the prototype pattern is implemented correctly, the Configuration class should have a cloneObject method");
        }
    }

    @Test
    public void testRegistry() {

        ConfigurationPrototypeRegistry registry = getRegistry();
        assertNotNull(registry, "If the registry pattern is implemented correctly, the registry should not be null");

        Configuration configuration = new Configuration("Black", true, "English", true, 12, "Arial", ConfigurationType.BASIC);
        registry.addPrototype(configuration);

        Configuration prototype = registry.getPrototype(configuration.getType());
        assertNotNull(prototype, "If the clone method is implemented correctly, it should return a non-null object");
        assertSame(configuration, prototype, "If the registry pattern is implemented correctly, the registry should return the same object that was added");
    }

    private static ConfigurationPrototypeRegistry getRegistry() {
        // Use Reflections to find the class implementing ConfigurationPrototypeRegistry
        Reflections reflections = new Reflections(ConfigurationTest.class.getPackageName(),
                new SubTypesScanner(false));
        Set<Class<? extends ConfigurationPrototypeRegistry>> classes = reflections.getSubTypesOf(ConfigurationPrototypeRegistry.class);

        // Ensure there is exactly one class implementing the interface
        assertEquals(1, classes.size(), "If the registry pattern is implemented correctly, there should be exactly one class implementing ConfigurationPrototypeRegistry");

        // Instantiate the registry implementation
        Class<? extends ConfigurationPrototypeRegistry> registryClass = classes.iterator().next();
        try {
            return registryClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            fail("If the registry pattern is implemented correctly, the registry class should have a public no-args constructor");
        }
        return null;
    }

    @Test
    public void testRegistryClone() {

        Configuration configuration = new Configuration("Black", true, "English", true, 12, "Arial", ConfigurationType.BASIC);
        ConfigurationPrototypeRegistry registry = getRegistry();
        assertNotNull(registry, "If the registry pattern is implemented correctly, the registry should not be null");

        registry.addPrototype(configuration);

        // Clone the prototype and validate it's a distinct object with the same values
        Configuration clonedConfiguration = registry.clone(configuration.getType());
        assertNotNull(clonedConfiguration, "If the clone method is implemented correctly, it should return a non-null object");
        assertNotSame(configuration, clonedConfiguration, "If the clone method is implemented correctly, it should return a new object");

        assertEquals(configuration.getThemeColor(), clonedConfiguration.getThemeColor(), "If the clone method is implemented correctly, it should return a new object with the same values as the original object");
        assertEquals(configuration.getAutoSave(), clonedConfiguration.getAutoSave(), "If the clone method is implemented correctly, it should return a new object with the same values as the original object");
        assertEquals(configuration.getFontSize(), clonedConfiguration.getFontSize(), "If the clone method is implemented correctly, it should return a new object with the same values as the original object");
        assertEquals(configuration.getDarkMode(), clonedConfiguration.getDarkMode(), "If the clone method is implemented correctly, it should return a new object with the same values as the original object");
        assertEquals(configuration.getLanguage(), clonedConfiguration.getLanguage(), "If the clone method is implemented correctly, it should return a new object with the same values as the original object");
        assertEquals(configuration.getFontFamily(), clonedConfiguration.getFontFamily(), "If the clone method is implemented correctly, it should return a new object with the same values as the original object");
        assertEquals(configuration.getType(), clonedConfiguration.getType(), "If the clone method is implemented correctly, it should return a new object with the same values as the original object");
    }
}