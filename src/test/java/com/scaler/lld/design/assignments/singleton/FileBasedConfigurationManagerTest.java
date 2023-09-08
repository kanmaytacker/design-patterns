package com.scaler.lld.design.assignments.singleton;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.io.TempDir;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class FileBasedConfigurationManagerTest {

    private static Class<? extends FileBasedConfigurationManager> implementationClass;

    @TempDir
    private Path tempDir;

    private Path tempConfigFile;

    @BeforeAll
    public static void setUpClass() {
        // Get the package name of the test class
        String packageName = FileBasedConfigurationManagerTest.class.getPackageName();

        // Use Reflections to scan for classes within the package
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        Set<Class<? extends FileBasedConfigurationManager>> subTypes = reflections
                .getSubTypesOf(FileBasedConfigurationManager.class);

        // Find a non-abstract implementation of FileBasedConfigurationManager
        for (Class<?> clazz : subTypes) {
            if (!Modifier.isAbstract(clazz.getModifiers())) {
                implementationClass = (Class<? extends FileBasedConfigurationManager>) clazz;
                break;
            }
        }
    }

    @Test
    public void preTestConfigurationManagerImplementationFound() {
        assertNotNull(implementationClass,
                "If an implementation of FileBasedConfigurationManager exists, it should be found");

        Constructor<?>[] constructors = implementationClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            assertFalse(Modifier.isPublic(constructor.getModifiers()),
                    "If an implementation of FileBasedConfigurationManager exists, it should not have a public constructor");
        }

        try {
            Method getInstanceMethod = implementationClass.getDeclaredMethod("getInstance");
            assertTrue(Modifier.isStatic(getInstanceMethod.getModifiers()),
                    "If getInstance() is present, it should be a static method");
        } catch (NoSuchMethodException e) {
            fail("If an implementation of FileBasedConfigurationManager exists, it should have a static getInstance() method");
        }

        try {
            Method resetInstanceMethod = implementationClass.getDeclaredMethod("resetInstance");
            assertTrue(Modifier.isStatic(resetInstanceMethod.getModifiers()),
                    "If resetInstance() is present, it should be a static method");

        } catch (NoSuchMethodException e) {
            fail("If an implementation of FileBasedConfigurationManager exists, it should have a static resetInstance() method");
        }
    }

    @BeforeEach
    public void setUp(TestInfo info) throws IOException {
        if (info.getDisplayName().startsWith("preTest")) {
            return;
        }

        resetInstance();

        tempConfigFile = Files.createTempFile(tempDir, "config", ".properties");
        Files.writeString(tempConfigFile, "stringKey=stringValue\nintKey=42");
    }

    private static void resetInstance() {
        try {
            Method resetInstanceMethod = implementationClass.getDeclaredMethod("resetInstance");
            resetInstanceMethod.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetInstanceMethod() {

        Assumptions.assumeTrue(implementationClass != null);

        FileBasedConfigurationManager instance = getInstance();
        assertNotNull(instance, "If getInstance() is called, it should return a non-null instance");
    }

    private static FileBasedConfigurationManager getInstance() {
        try {

            Method getInstanceMethod = implementationClass.getDeclaredMethod("getInstance");
            FileBasedConfigurationManager instance = (FileBasedConfigurationManager) getInstanceMethod.invoke(null);
            return instance;
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    public void testSingletonBehavior() {

        Assumptions.assumeTrue(implementationClass != null);

        FileBasedConfigurationManager instance1 = getInstance();
        Assumptions.assumeTrue(instance1 != null);

        FileBasedConfigurationManager instance2 = getInstance();

        assertSame(instance1, instance2,
                "If getInstance() is called multiple times, it should return the same instance");
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    public void testSingletonThreadSafety() throws InterruptedException {

        int numThreads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        CountDownLatch latch = new CountDownLatch(numThreads);
        FileBasedConfigurationManager[] instances = new FileBasedConfigurationManager[numThreads];

        for (int i = 0; i < numThreads; i++) {
            final int index = i;
            executorService.submit(() -> {
                instances[index] = getInstance();
                latch.countDown();
            });
        }

        latch.await();
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        FileBasedConfigurationManager referenceInstance = instances[0];
        for (int i = 1; i < numThreads; i++) {
            assertSame(referenceInstance, instances[i],
                    "If getInstance() is called by multiple threads, it should return the same instance");
        }
    }

    @Test
    public void testResetInstanceMethod() {

        Assumptions.assumeTrue(implementationClass != null);

        FileBasedConfigurationManager instance1 = getInstance();
        Assumptions.assumeTrue(instance1 != null);

        resetInstance();

        FileBasedConfigurationManager instance2 = getInstance();

        assertNotSame(instance1, instance2,
                "If resetInstance() is called, getInstance() should return a new instance");
    }

    @Test
    public void testGetConfiguration() {

        Assumptions.assumeTrue(implementationClass != null);

        FileBasedConfigurationManager instance = getInstance();
        Assumptions.assumeTrue(instance != null);

        instance.load(tempConfigFile.toString());

        String value = instance.getConfiguration("stringKey");

        assertEquals("stringValue", value, "If a configuration value exists, it should be returned");
    }

    @Test
    public void testGetConfigurationWithTypeConversion() {

        Assumptions.assumeTrue(implementationClass != null);

        FileBasedConfigurationManager instance = getInstance();
        Assumptions.assumeTrue(instance != null);

        instance.load(tempConfigFile.toString());

        int intValue = instance.getConfiguration("intKey", Integer.class);

        assertEquals(42, intValue, "If a configuration value exists, it should be returned after type conversion");
    }

    @Test
    public void testSetConfiguration() {

        Assumptions.assumeTrue(implementationClass != null);

        FileBasedConfigurationManager instance = getInstance();
        Assumptions.assumeTrue(instance != null);

        instance.load(tempConfigFile.toString());

        instance.setConfiguration("newKey", "newValue");
        String value = instance.getConfiguration("newKey");

        assertEquals("newValue", value, "If a configuration value is set, it should be returned by getConfiguration()");
    }

    @Test
    public void testRemoveConfiguration() {

        Assumptions.assumeTrue(implementationClass != null);

        FileBasedConfigurationManager instance = getInstance();
        Assumptions.assumeTrue(instance != null);

        instance.load(tempConfigFile.toString());

        instance.removeConfiguration("stringKey");
        String value = instance.getConfiguration("stringKey");

        assertNull(value,
                "If a configuration value is removed, it should return null when getConfiguration() is called");
    }

    @Test
    public void testClear() {

        Assumptions.assumeTrue(implementationClass != null);

        FileBasedConfigurationManager instance = getInstance();
        Assumptions.assumeTrue(instance != null);

        instance.load(tempConfigFile.toString());

        instance.clear();

        String stringValue = instance.getConfiguration("stringKey");
        Integer intValue = instance.getConfiguration("intKey", Integer.class);

        assertNull(stringValue, "If the configuration is cleared, getConfiguration() should return null");
        assertNull(intValue, "If the configuration is cleared, getConfiguration() should return null");
    }

}